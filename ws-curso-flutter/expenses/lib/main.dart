import 'dart:math';

import 'package:expenses/components/transaction_form.dart';
import 'package:expenses/components/transaction_list.dart';
import 'package:flutter/material.dart';

import 'models/transaction.dart';


main() => runApp(const ExpensesApp());

class ExpensesApp extends StatelessWidget {
  const ExpensesApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  final _transactions = [
    Transaction(
        id: 't1', title: 'Conta de água', value: 50.76, date: DateTime.now()),
    Transaction(
        id: 't2', title: 'Conta de luz', value: 211.70, date: DateTime.now())
  ];
  
  _openTransactionFormModal(BuildContext buildContext) {
    showModalBottomSheet(
      context: buildContext, 
      builder: (_){
        return TransactionForm(_addTransaction);
      }
    );
  }

  _addTransaction(String title, double value) {
    final newTransaction = Transaction(
      id: Random().nextDouble().toString(),
      title: title,
      value: value,
      date: DateTime.now()
    );
    setState(() {
      _transactions.add(newTransaction);
    });
    Navigator.of(context).pop();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Despesas pessoais'),
        actions: [
          IconButton(
            onPressed: ()=> _openTransactionFormModal(context), 
            icon: const Icon(Icons.add),
          )
        ],
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          const SizedBox(
            width: double.infinity,
            child:
                Card(color: Colors.blue, elevation: 5, child: Text('Gráfico')),
          ),
          Column(
            children: [
              TransactionList(_transactions)
            ],
          )
        ],
      ),
      floatingActionButton: FloatingActionButton(onPressed: ()=> _openTransactionFormModal(context), child: const Icon(Icons.add),),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
    );
  }
}
