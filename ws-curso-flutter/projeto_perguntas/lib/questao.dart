import 'package:flutter/cupertino.dart';
import 'package:flutter/src/widgets/framework.dart';

class Questao extends StatelessWidget {
  final String texto;
  Questao(this.texto);

  @override
  Widget build(BuildContext context) {
    return Text(texto);
  }
}
