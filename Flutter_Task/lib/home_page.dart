import 'package:flutter/material.dart';
import 'parent_login.dart';
import 'kids_page.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Positioned.fill(
            child: Container(
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage('assets/home_bg.png'),
                  fit: BoxFit.cover,
                ),
              ),
            ),
          ),
          SafeArea(
            child: Column(
              children: [
                Spacer(),
                // Enlarged Piggy Image
                Image.asset('assets/piggy.png', height: 300), 
                
                SizedBox(height: 20),
                Text(
                  'Virtual Piggy Bank',
                  style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                    letterSpacing: 1.2,
                  ),
                ),
                SizedBox(height: 40),
                
                // Updated buttons with theme colors
                MenuButton(
                  icon: Icons.person,
                  text: 'Parent',
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => ParentLoginPage()),
                    );
                  },
                  color: Colors.purple.shade400, // Updated to match theme
                ),
                MenuButton(
                  icon: Icons.child_care,
                  text: 'Kids',
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(builder: (context) => KidsPage()),
                    );
                  },
                  color: Colors.pink.shade400, // More cohesive with theme
                ),
                MenuButton(
                  icon: Icons.info,
                  text: 'About',
                  onTap: () {
                    showAboutDialog(
                      context: context,
                      applicationName: 'Virtual Piggy Bank',
                      applicationVersion: '1.0',
                      children: [
                        Text('A virtual piggy bank to help kids manage money.')
                      ],
                    );
                  },
                  color: Colors.blue.shade400, // Complementary color
                ),
                Spacer(),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

class MenuButton extends StatelessWidget {
  final IconData icon;
  final String text;
  final VoidCallback onTap;
  final Color color;

  const MenuButton({
    required this.icon,
    required this.text,
    required this.onTap,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 50),
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          padding: EdgeInsets.symmetric(vertical: 15),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(30),
          ),
          backgroundColor: color,
          foregroundColor: Colors.white,
          shadowColor: Colors.black26,
          elevation: 5,
        ),
        onPressed: onTap,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(icon, size: 24),
            SizedBox(width: 10),
            Text(
              text,
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
