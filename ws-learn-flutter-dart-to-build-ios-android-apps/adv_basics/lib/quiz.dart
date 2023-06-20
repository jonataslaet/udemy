import 'package:adv_basics/models/questions.dart';
import 'package:adv_basics/questions_screen.dart';
import 'package:adv_basics/results_screen.dart';
import 'package:adv_basics/start_screen.dart';
import 'package:flutter/material.dart';

class Quiz extends StatefulWidget {
  const Quiz({super.key});

  @override
  State<StatefulWidget> createState() {
    return _QuizState();
  }
}

class _QuizState extends State<Quiz> {
  List<String> selectedAnswers = [];
  Widget? chosenScreen;
  String? activeScreen;

  void switchScreen() {
    setState(() {
      activeScreen = 'questions-screen';
    });
  }

  void chooseAnswer(answer) {
    selectedAnswers.add(answer);
    if (selectedAnswers.length == questions.length) {
      setState(() {
        activeScreen = 'results-screen';
      });
    }
  }

  @override
  void initState() {
    super.initState();
    activeScreen = 'start-screen';
  }

  @override
  Widget build(context) {
    if (activeScreen == 'start-screen') {
      chosenScreen = StartScreen(switchScreen);
    } else if (activeScreen == 'questions-screen') {
      chosenScreen = QuestionsScreen(onSelectedAnswer: chooseAnswer);
    } else if (activeScreen == 'results-screen') {
      chosenScreen = ResultsScreen(chosenAnswers: selectedAnswers,);
      selectedAnswers = [];
    }
    return MaterialApp(
      home: Scaffold(
        body: Container(
          decoration: const BoxDecoration(
            gradient: LinearGradient(colors: [
              Color.fromARGB(255, 78, 13, 151),
              Color.fromARGB(255, 107, 15, 168),
            ], begin: Alignment.topLeft, end: Alignment.bottomRight),
          ),
          child: chosenScreen,
        ),
      ),
    );
  }
}
