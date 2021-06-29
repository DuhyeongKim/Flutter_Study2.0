import 'package:flutter/material.dart';
import 'dart:io';
// Import the firebase_core and cloud_firestore plugin
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_storage/firebase_storage.dart';

import 'package:image_picker/image_picker.dart';
import 'package:path/path.dart';
import 'home.dart';

_AddUserState pageState;

class AddUser extends StatefulWidget {
  @override
  _AddUserState createState() {

    pageState = _AddUserState();
    return pageState;
  }
}

class _AddUserState extends State<AddUser> {
  var firestore = FirebaseFirestore.instance;
  File _image;


  final GlobalKey<ScaffoldState> _scaffoldKey = new GlobalKey<ScaffoldState>();

  // 컬렉션명
  final picker = ImagePicker();

  Future getImage() async {
    final pickedFile = await picker.getImage(source: ImageSource.camera);

    setState(() {

      if (pickedFile != null) {
        _image = File(pickedFile.path);
      } else {
        print('No image selected.');
      }
    });
  }




  final String colName = "add";
  final String fnName = "name";
  final String fnDescription = "description";
  final String fnPrice = "price";

  TextEditingController _newNameCon = TextEditingController();
  TextEditingController _newDescCon = TextEditingController();
  TextEditingController _newPriceCon = TextEditingController();
  TextEditingController _undNameCon = TextEditingController();
  TextEditingController _undDescCon = TextEditingController();
  TextEditingController _undPrice1Con = TextEditingController();



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: _scaffoldKey,
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(
            Icons.delete,

          ),
          onPressed: () {
            _newNameCon.clear();
            _newDescCon.clear();
            Navigator.pop(context);
          },
        ),
        title: Text('ADD'),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.save,
            ),
            onPressed: () {
              if (_newDescCon.text.isNotEmpty &&
                  _newNameCon.text.isNotEmpty) {
                createDoc(_newNameCon.text, _newDescCon.text, _newPriceCon.text);
              }
              _newNameCon.clear();
              _newDescCon.clear();
              Navigator.pop(context);
            },
          ),
      ],
      ),
      body: ListView(
        children: <Widget>[

      Center(
                  child: _image == null
                      ? Image.asset('assets/logo.png',height: 100, width: 100)
                      : Image.file(_image),

                ),


                TextField(
                  autofocus: true,
                  decoration: InputDecoration(labelText: "Name"),
                  controller: _newNameCon,
                ),
                TextField(
                  decoration: InputDecoration(labelText: "Price"),
                  controller: _newPriceCon,
                ),
                TextField(
                  decoration: InputDecoration(labelText: "Description"),
                  controller: _newDescCon,
                )

              ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: getImage,
        tooltip: 'Pick Image',
        child: Icon(Icons.add_a_photo),
      ),
    );
  }
  void createDoc(String name, String description, String price) {
    firestore.collection(colName).add({
      fnName: name,
      fnDescription: description,
      fnPrice: price,
    });
  }
}
