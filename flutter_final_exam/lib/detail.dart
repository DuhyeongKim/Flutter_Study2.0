
import 'dart:io';

import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:path_provider/path_provider.dart';
import 'package:firebase_storage/firebase_storage.dart' as firebase_storage;

Future<void> downloadFileExample() async {
  Directory appDocDir = await getApplicationDocumentsDirectory();
  File downloadToFile = File('${appDocDir.path}/download-logo.png');

  try {
    await firebase_storage.FirebaseStorage.instance
        .ref('uploads/logo.png')
        .writeToFile(downloadToFile);
  } catch (e) {
    // e.g, e.code == 'canceled'
  }


  FirebaseApp secondaryApp = Firebase.app('posts');
  firebase_storage.FirebaseStorage storage =
  firebase_storage.FirebaseStorage.instanceFor(app: secondaryApp);
}



class DetailPage extends StatefulWidget {

  final DocumentSnapshot post;

  DetailPage({this.post});




  @override
  _DetailPageState createState() => _DetailPageState();
}

class _DetailPageState extends State<DetailPage> {



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(
            Icons.west_outlined,

          ),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        title: Text('Detail'),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.app_registration,
            ),
            onPressed: () {

            },
          ),
          IconButton(
            icon: Icon(
              Icons.delete,
            ),
            onPressed: () {

            },
          ),
        ],
      ),
      body: ListView(
        children: <Widget>[

          Center(

          ),


          TextField(
            autofocus: true,
            decoration: InputDecoration(labelText: "Name"),

          ),
          TextField(
            decoration: InputDecoration(labelText: "Price"),

          ),
          TextField(
            decoration: InputDecoration(labelText: "Description"),

          )

        ],
      ),

    );
  }
}
