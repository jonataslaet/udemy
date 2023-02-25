import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/src/widgets/framework.dart';

class Resposta extends StatelessWidget {
  final String texto;
  final void Function() quandoSelecionado;

  Resposta(this.texto, this.quandoSelecionado);

  @override
  Widget build(BuildContext context) {
    var textStyle = TextStyle(color: Colors.white);
    return Container(
      width: double.infinity,
      child: ElevatedButton(
          onPressed: quandoSelecionado,
          child: Text(
            texto,
            style: textStyle,
            selectionColor: Colors.blue,
          )),
    );
  }
}
