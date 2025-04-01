  import 'package:flutter/material.dart'; 
  import 'package:cloud_firestore/cloud_firestore.dart';
  import 'package:http/http.dart' as http;
  import 'dart:convert';
  import 'package:flutter/services.dart';
  import 'package:myflutterprj/chores.dart';

  class KidsPage extends StatefulWidget {
    @override
    _KidsPageState createState() => _KidsPageState();
    }

  class _KidsPageState extends State<KidsPage> {
    final FirebaseFirestore _firestore = FirebaseFirestore.instance;
    List<dynamic> _storeItems = [];
    List<dynamic> _charities = [];
    String? _selectedCharity;
    TextEditingController _amountController = TextEditingController();

    @override
    void initState() {
      super.initState();
      fetchStoreItems();
      _loadCharities();
    }

    Future<void> fetchStoreItems() async {
      final response = await http.get(Uri.parse("https://fakestoreapi.com/products"));

      if (response.statusCode == 200) {
        setState(() {
          _storeItems = json.decode(response.body);
        });
      } else {
        throw Exception("Failed to load store items");
      }
    }

    Future<void> _loadCharities() async {
      String data = await rootBundle.loadString('assets/charities.json');
      setState(() {
        _charities = json.decode(data);
      });
    }

    void _buyItem(double allocatedAmount, double itemPrice) async {
      if (itemPrice > allocatedAmount) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Insufficient funds to buy this item')),
        );
        return;
      }

      await _firestore.collection('allowance').doc('child').update({
        'amount': allocatedAmount - itemPrice,
      });

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Purchase successful! ₹$itemPrice deducted.')),
      );
    }

    void _showStoreDialog(double allocatedAmount) {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
           backgroundColor: Colors.white,
          title: Text('Store Items', style: TextStyle(fontSize: 28, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
          content: Container(
            width: double.maxFinite,
            height: 450,
            child: _storeItems.isEmpty
                ? Center(child: CircularProgressIndicator())
                : ListView.builder(
                    itemCount: _storeItems.length,
                    itemBuilder: (context, index) {
                      var item = _storeItems[index];
                      return Card(
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(20),
                          side: BorderSide(color: Colors.purple.shade400, width: 2),
                        ),
                        color: Colors.white,
                        elevation: 8,
                        margin: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                        child: Padding(
                          padding: EdgeInsets.all(12),
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              ClipRRect(
                                borderRadius: BorderRadius.circular(15),
                                child: Image.network(item['image'], width: 100, height: 100, fit: BoxFit.cover),
                              ),
                              SizedBox(height: 10),
                              Text(
                                item['title'],
                                textAlign: TextAlign.center,
                                style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.purple.shade400),
                              ),
                              SizedBox(height: 5),
                              Text(
                                "₹${item['price']}",
                                style: TextStyle(fontSize: 20, color: Colors.purple.shade400, fontWeight: FontWeight.bold),
                              ),
                              SizedBox(height: 10),
                              ElevatedButton(
                                onPressed: () => _buyItem(allocatedAmount, item['price']),
                                style: ElevatedButton.styleFrom(
                                  backgroundColor: Colors.purple.shade400,
                                  shape: RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(12),
                                  ),
                                  padding: EdgeInsets.symmetric(vertical: 14, horizontal: 30),
                                ),
                                child: Text(
                                  'Buy',
                                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white),
                                ),
                              ),
                            ],
                          ),
                        ),
                      );
                    },
                  ),
          ),
          actions: [
              TextButton(
                onPressed: () => Navigator.pop(context),
                child: Text('Close', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
              ),
            ],
          );
        },
      );
    }

    void _showDonationDialog(double allocatedAmount) {
      showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
          backgroundColor: Colors.white,
            title: Text('Donate to Charity', style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
            content: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                DropdownButton<String>(
                  value: _selectedCharity,
                  dropdownColor: Colors.white,
                  hint: Text('Select a Charity', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
                  onChanged: (String? newValue) {
                    setState(() {
                      _selectedCharity = newValue;
                    });
                  },
                  items: _charities.map<DropdownMenuItem<String>>((dynamic charity) {
                    return DropdownMenuItem<String>(
                      value: charity['name'],
                      child: Text(charity['name'], style: TextStyle(fontSize: 18, color: Colors.purple.shade400)),
                    );
                  }).toList(),
                ),
                SizedBox(height: 20),
                TextField(
                  controller: _amountController,
                  keyboardType: TextInputType.number,
                  style: TextStyle(color: Colors.purple.shade400, fontSize: 18),
                  decoration: InputDecoration(
                    labelText: 'Donation Amount',
                    labelStyle: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.purple.shade400),
                    enabledBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.purple.shade400),
                      borderRadius: BorderRadius.circular(10),
                    ),
                    focusedBorder: OutlineInputBorder(
                      borderSide: BorderSide(color: Colors.purple.shade400, width: 2),
                      borderRadius: BorderRadius.circular(10),
                    ),
                  ),
                ),
              ],
            ),
  actions: [
              TextButton(
                onPressed: () => Navigator.pop(context),
                child: Text('Cancel', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.pop(context);
                  _donate(allocatedAmount);
                },
                child: Text('Donate', style: TextStyle(color: Colors.white)),
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsets.symmetric(vertical: 20, horizontal: 40),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(30),
                  ),
                  backgroundColor: Colors.purple.shade400,
                ),
              ),
            ],
          );
        },
      );
    }

    void _donate(double allocatedAmount) {
      double donationAmount = double.tryParse(_amountController.text) ?? 0.0;
      if (_selectedCharity == null || donationAmount <= 0) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Please select a charity and enter a valid amount')),
        );
        return;
      }

      if (donationAmount > allocatedAmount) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Insufficient funds')),
        );
        return;
      }

      _firestore.collection('allowance').doc('child').update({
        'amount': allocatedAmount - donationAmount,
      });

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('You donated ₹$donationAmount to $_selectedCharity')),
      );

      _amountController.clear();
      setState(() {
        _selectedCharity = null;
      });
    }

    @override
    Widget build(BuildContext context) {
      return Scaffold(
        appBar: AppBar(
          title: Text('Kids Dashboard',
              style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.white)),
          backgroundColor: Colors.purple.shade400,
        ),
        body: Stack(
          children: [
            // Background Image
            Positioned.fill(
              child: Image.asset(
                'assets/bg.png',
                fit: BoxFit.cover, // Adjust image to fit screen
              ),
            ),

            // Main Content
            StreamBuilder<DocumentSnapshot>(
              stream: _firestore.collection('allowance').doc('child').snapshots(),
              builder: (context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return Center(child: CircularProgressIndicator());
                }
                if (!snapshot.hasData || !snapshot.data!.exists) {
                  return Center(child: Text('No allowance set yet.', style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)));
                }
                var data = snapshot.data!;
                double allocatedAmount = data['amount'] ?? 0.0;

                return Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
SizedBox(height: 80), // Moves everything slightly upwards
Padding(
padding: const EdgeInsets.symmetric(vertical: 16.0, horizontal: 8.0),
child: Center(
child: Text(
'Total Allocated Amount:\n₹${allocatedAmount.toStringAsFixed(2)}', // Format to 2 decimal places
textAlign: TextAlign.center,
style: TextStyle(
fontSize: 22,
fontWeight: FontWeight.bold,
color: Colors.white,
fontFamily: 'ComicNeue', // A playful, child-friendly font
),
),
),
),
                    SizedBox(height: 30),

                    ElevatedButton(
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => ChoresPage()),
                        );
                      },
                      child: Text("Chores", style: TextStyle(color: Colors.white, fontSize: 20)),
                      style: ElevatedButton.styleFrom(
                        padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30),
                        ),
                        backgroundColor: Colors.purple.shade400,
                      ),
                    ),
                    SizedBox(height: 30),
                    ElevatedButton(
                      onPressed: () => _showDonationDialog(allocatedAmount),
                      child: Text('Donate to Charity', style: TextStyle(color: Colors.white, fontSize: 20)),
                      style: ElevatedButton.styleFrom(
                        padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30),
                        ),
                        backgroundColor: Colors.purple.shade400,
                      ),
                    ),
                    SizedBox(height: 30),
                    ElevatedButton(
                      onPressed: () => _showStoreDialog(allocatedAmount),
                      child: Text('View Store Items', style: TextStyle(color: Colors.white, fontSize: 20)),
                      style: ElevatedButton.styleFrom(
                        padding: EdgeInsets.symmetric(vertical: 25, horizontal: 60),
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(30),
                        ),
                        backgroundColor: Colors.purple.shade400,
                      ),
                    ),
                  ],
                );
              },
            ),
          ],
        ),
      );
    }}