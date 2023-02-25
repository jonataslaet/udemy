import 'package:flutter/material.dart';
import 'package:projeto_perguntas/questionario.dart';
import 'package:projeto_perguntas/resultado.dart';

void main() {
  runApp(new PerguntaApp());
}

class _PerguntaAppState extends State<PerguntaApp> {
  var _perguntaSelecionada = 0;
  var _pontuacaoTotal = 0;

  final List<Map<String, Object>> _perguntas = const [
    {
      'texto': 'Qual é sua cor favorita?',
      'respostas': [
        {
          'texto': 'Preto',
          'nota': 10,
        },
        {
          'texto': 'Vermelho',
          'nota': 5,
        },
        {
          'texto': 'Verde',
          'nota': 3,
        },
        {
          'texto': 'Branco',
          'nota': 1,
        }
      ],
    },
    {
      'texto': 'Qual é seu animal favorito?',
      'respostas': [
        {
          'texto': 'Coelho',
          'nota': 10,
        },
        {
          'texto': 'Cobra',
          'nota': 5,
        },
        {
          'texto': 'Elefante',
          'nota': 3,
        },
        {
          'texto': 'Leão',
          'nota': 1,
        }
      ],
    },
    {
      'texto': 'Qual é seu instrutor favorito?',
      'respostas': [
        {
          'texto': 'Maria',
          'nota': 10,
        },
        {
          'texto': 'João',
          'nota': 5,
        },
        {
          'texto': 'Leonardo',
          'nota': 3,
        },
        {
          'texto': 'Pedro',
          'nota': 1,
        },
      ],
    }
  ];

  void _responder(int nota) {
    if (temPerguntaSelecionada) {
      setState(() {
        _perguntaSelecionada++;
        _pontuacaoTotal += nota;
      });
      print('Pergunta respondida!');
      print('Nota = ${nota}');
      print('Total = ${_pontuacaoTotal}');
    }
  }

  void _reiniciarQuestionario() {
    setState(() {
      _perguntaSelecionada = 0;
      _pontuacaoTotal = 0;
    });
  }

  bool get temPerguntaSelecionada {
    return _perguntaSelecionada < _perguntas.length;
  }

  @override
  Widget build(BuildContext context) {
    List<Map<String, Object>> respostas = temPerguntaSelecionada
        ? _perguntas[_perguntaSelecionada].cast()['respostas']
            as List<Map<String, Object>>
        : [];

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Perguntas'),
        ),
        body: temPerguntaSelecionada
            ? Questionario(
                perguntas: _perguntas,
                perguntaSelecionada: _perguntaSelecionada,
                responder: _responder)
            : Resultado(_pontuacaoTotal, _reiniciarQuestionario),
      ),
    );
  }
}

class PerguntaApp extends StatefulWidget {
  _PerguntaAppState createState() {
    return _PerguntaAppState();
  }
}
