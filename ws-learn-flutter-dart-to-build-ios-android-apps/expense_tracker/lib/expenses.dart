import 'package:flutter/material.dart';

class Expenses extends StatefulWidget {
  const Expenses({super.key});

  State<Expenses> createState() {
    return _ExpensesStates();
  }
}

class _ExpensesStates extends State<Expenses> {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Column(
        children: [
          Text('Teh chart'),
          Text('Expenses List'),
        ],
      ),
    );
  }
}
