import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/services.dart';
import 'dart:convert';

class ChoresPage extends StatefulWidget {
  @override
  _ChoresPageState createState() => _ChoresPageState();
}

class _ChoresPageState extends State<ChoresPage> {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;
  List<dynamic> _chores = [];
  String _parentPassword = "parent@code"; // Set parent password

  @override
  void initState() {
    super.initState();
    _loadChores();
  }

  Future<void> _loadChores() async {
    String data = await rootBundle.loadString('assets/chores.json');
    setState(() {
      _chores = json.decode(data);
    });
  }

  void _showPasswordDialog(String task, double reward) {
    TextEditingController _passwordController = TextEditingController();

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
          backgroundColor: Colors.white,
          title: Text("Parent Approval Required", style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text("Enter parent password to confirm completion of task:",
                  textAlign: TextAlign.center, style: TextStyle(fontSize: 16, color: Colors.black)),
              SizedBox(height: 10),
              TextField(
                controller: _passwordController,
                obscureText: true,
                decoration: InputDecoration(
                  labelText: "Password",
                  border: OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
                ),
              ),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Cancel", style: TextStyle(fontSize: 18, color: Colors.purple.shade400)),
            ),
            ElevatedButton(
              onPressed: () async {
                if (_passwordController.text == _parentPassword) {
                  await _updateBalance(reward);
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("₹$reward added for '$task'!")),
                  );
                  Navigator.pop(context);
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("Incorrect password!")),
                  );
                }
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.purple.shade400,
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
              ),
              child: Text("Confirm", style: TextStyle(fontSize: 18, color: Colors.white)),
            ),
          ],
        );
      },
    );
  }

  Future<void> _updateBalance(double reward) async {
    DocumentSnapshot snapshot = await _firestore.collection('allowance').doc('child').get();
    double currentAmount = snapshot.exists ? (snapshot['amount'] ?? 0.0) : 0.0;
    double updatedAmount = currentAmount + reward;

    await _firestore.collection('allowance').doc('child').set({
      'amount': updatedAmount,
      'timestamp': FieldValue.serverTimestamp(),
    });

    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
      backgroundColor: Colors.white,
      title: Text("Complete Chores", style: TextStyle(fontSize: 26, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
      content: _chores.isEmpty
          ? Center(child: CircularProgressIndicator())
          : SingleChildScrollView(
              child: Column(
                children: _chores.map((chore) {
                  return Card(
                    shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
                    margin: EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                    elevation: 5,
                    child: CheckboxListTile(
                      contentPadding: EdgeInsets.all(12),
                      title: Text(
                        chore['task'],
                        style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.purple.shade400),
                      ),
                      subtitle: Text(
                        "Reward: ₹${chore['reward']}",
                        style: TextStyle(fontSize: 18, color: Colors.black),
                      ),
                      value: false,
                      onChanged: (bool? value) {
                        if (value == true) {
                          _showPasswordDialog(chore['task'], chore['reward'].toDouble());
                        }
                      },
                      activeColor: Colors.purple.shade400,
                    ),
                  );
                }).toList(),
              ),
            ),
      actions: [
        TextButton(
          onPressed: () => Navigator.pop(context),
          child: Text("Close", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.purple.shade400)),
        ),
      ],
    );
  }
}
