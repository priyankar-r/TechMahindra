import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class SavingsPage extends StatelessWidget {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Savings & Transactions', style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.white)),
        backgroundColor: Colors.purple.shade400,
        centerTitle: true,
      ),
      body: Container(
        child: Column(
          children: [
            SizedBox(height: 20),
            // Display Balance
            StreamBuilder<DocumentSnapshot>(
              stream: _firestore.collection('allowance').doc('child').snapshots(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Padding(
                    padding: const EdgeInsets.symmetric(vertical: 40.0),
                    child: Center(child: CircularProgressIndicator()),
                  );
                }
                // Default text when no data - formatted to two decimal places
                if (!snapshot.hasData || !snapshot.data!.exists) {
                   return Padding(
                      padding: const EdgeInsets.symmetric(vertical: 40.0, horizontal: 16.0),
                      child: Center(
                        child: Text(
                          'Balance: ₹0.00', // Updated default display
                          style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.purple.shade300),
                          textAlign: TextAlign.center,
                        ),
                      ),
                   );
                }
                var balanceData = snapshot.data!.data() as Map<String, dynamic>;

                // *** FORMATTING BALANCE HERE ***
                num? balanceAmount = balanceData['amount'] as num?; // Cast safely to num?
                // Format to 2 decimal places, default to '0.00' if null
                String formattedBalance = balanceAmount?.toStringAsFixed(2) ?? '0.00';

                 return Padding(
                    padding: const EdgeInsets.symmetric(vertical: 40.0, horizontal: 16.0),
                    child: Center(
                      child: Text(
                        // Use the formatted string
                        'Amount Saved last month ₹$formattedBalance',
                        style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.purple.shade300),
                        textAlign: TextAlign.center,
                      ),
                    ),
                 );
              },
            ), // End of Balance StreamBuilder

            // Image
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 80.0, horizontal: 80.0),
              child: Image.asset(
                'assets/savingpage.png', // MAKE SURE THIS PATH IS CORRECT
                height: 250,
                fit: BoxFit.contain,
                semanticLabel: 'Illustration related to savings',
              ),
            ),

            // Transaction List
            Expanded(
              child: StreamBuilder<QuerySnapshot>(
                stream: _firestore
                    .collection('transactions')
                    .orderBy('timestamp', descending: true)
                    .snapshots(),
                builder: (context, snapshot) {
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    return Center(child: CircularProgressIndicator());
                  }
                  if (!snapshot.hasData || snapshot.data!.docs.isEmpty) {
                    return SizedBox.shrink();
                  }

                  var transactions = snapshot.data!.docs;
                  List<Map<String, dynamic>> donations = [];
                  List<Map<String, dynamic>> purchases = [];

                  for (var doc in transactions) {
                    var data = doc.data() as Map<String, dynamic>;
                    if (data['type'] == 'donation') {
                      donations.add(data);
                    } else if (data['type'] == 'purchase') {
                      purchases.add(data);
                    }
                  }

                  return ListView(
                    padding: EdgeInsets.fromLTRB(16.0, 0, 16.0, 16.0),
                    children: [
                      if (donations.isNotEmpty) ...[
                        _buildSectionTitle('Donations'),
                        ...donations.map((data) => _buildTransactionTile(data)).toList(),
                        SizedBox(height: 10),
                      ],
                      if (purchases.isNotEmpty) ...[
                        _buildSectionTitle('Store Purchases'),
                        ...purchases.map((data) => _buildTransactionTile(data)).toList(),
                      ],
                    ],
                  );
                },
              ),
            ), // End of Transaction List Expanded

            // TIPS PARAGRAPH (FOOTER)
            Padding(
              padding: const EdgeInsets.fromLTRB(20.0, 10.0, 20.0, 20.0),
              child: Card(
                color: Colors.purple.shade50.withOpacity(0.8),
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
                elevation: 2,
                child: Padding(
                  padding: const EdgeInsets.all(12.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        "Tips for Teaching Kids Savings:",
                        style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.purple.shade700),
                      ),
                      SizedBox(height: 8),
                      Text(
                        "Start early with simple concepts. Use a clear jar or this app to visualize savings growing. Help them set achievable goals for things they want. Discuss needs vs. wants when shopping. Most importantly, lead by example with your own saving habits!",
                        style: TextStyle(fontSize: 15, color: Colors.black87, height: 1.4),
                      ),
                    ],
                  ),
                ),
              ),
            ), // End of Tips Paragraph

          ],
        ),
      ),
    );
  }

  // Section Title Widget - Unchanged
  Widget _buildSectionTitle(String title) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 10.0, horizontal: 16.0),
      child: Text(
        title,
        style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.purple.shade300),
      ),
    );
  }

  // Transaction Tile Widget - Modified for formatting
  Widget _buildTransactionTile(Map<String, dynamic> data) {
    String dateString = "Date unavailable";
    if (data['timestamp'] != null && data['timestamp'] is Timestamp) {
       try {
          // Consider using intl package for better date formatting if possible in future
          dateString = (data['timestamp'] as Timestamp).toDate().toString().substring(0, 16); // Basic substring formatting
       } catch (e) {
          print("Error formatting date: $e");
       }
    }

    // *** FORMATTING TRANSACTION AMOUNT HERE ***
    num? transactionAmount = data['amount'] as num?; // Cast safely to num?
    // Format to 2 decimal places, default to 'N/A' if null
    String formattedAmount = transactionAmount?.toStringAsFixed(2) ?? 'N/A';


    return Card(
      color: Colors.white.withOpacity(0.9),
      margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
      child: ListTile(
        contentPadding: EdgeInsets.all(12),
        title: Text(
          '${data['name'] ?? 'Unknown Item'}',
          style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.purple.shade400),
        ),
        subtitle: Text(
          // Use the formatted string
          'Amount: ₹$formattedAmount',
          style: TextStyle(fontSize: 18, color: Colors.black87),
        ),
        trailing: Text(
          dateString,
          style: TextStyle(fontSize: 14, color: Colors.grey.shade700),
        ),
      ),
    );
  }
}