import 'package:flutter/material.dart';

import 'login.dart';


class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final appTitle = 'Form Validation Demo';

    return MaterialApp(
      title: appTitle,
      home: Scaffold(
        appBar: AppBar(
          title: Text(appTitle),
        ),
        body: MyCustomForm(),
      ),
    );
  }
}

// Create a Form widget.
class MyCustomForm extends StatefulWidget {
  @override
  MyCustomFormState createState() {
    return MyCustomFormState();
  }
}

// Create a corresponding State class.
// This class holds data related to the form.
class MyCustomFormState extends State<MyCustomForm> {
  // Create a global key that uniquely identifies the Form widget
  // and allows validation of the form.
  //
  // Note: This is a GlobalKey<FormState>,
  // not a GlobalKey<MyCustomFormState>.
  final _usernameController = TextEditingController();
  final _passwordController = TextEditingController();
  final _confirmController = TextEditingController();
  final _emailController = TextEditingController();
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    // Build a Form widget using the _formKey created above.
    return Form(
      key: _formKey,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          SizedBox(height: 12.0),
          // TODO: Wrap Username with AccentColorOverride (103)
          // TODO: Remove filled: true values (103)
          TextFormField(
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter Username';
              }
              return null;
            },
            controller: _usernameController,
            decoration: InputDecoration(
              filled: true,
              labelText: 'Username',
            ),
          ),
          SizedBox(height: 12.0),
          // TODO: Wrap Username with AccentColorOverride (103)
          // TODO: Remove filled: true values (103)
          TextFormField(
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter Password';
              }
              return null;
            },
            controller: _passwordController,
            decoration: InputDecoration(
              filled: true,
              labelText: 'Confirm Password',
            ),
          ),
          SizedBox(height: 12.0),
          // TODO: Wrap Username with AccentColorOverride (103)
          // TODO: Remove filled: true values (103)
          TextFormField(
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter Confrim Password';
              }
              return null;
            },
            controller: _confirmController,
            decoration: InputDecoration(
              filled: true,
              labelText: 'Confirm Password',
            ),
          ),
          SizedBox(height: 12.0),
          // TODO: Wrap Username with AccentColorOverride (103)
          // TODO: Remove filled: true values (103)
          TextFormField(
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'Please enter Email Address';
              }
              return null;
            },
            controller: _emailController,
            decoration: InputDecoration(
              filled: true,
              labelText: 'Email Address',
            ),

          ),
          Padding(
            padding: const EdgeInsets.symmetric(vertical: 16.0),
            child: ElevatedButton(
              onPressed: () {
                // Validate returns true if the form is valid, or false otherwise.
                if (!_formKey.currentState.validate()) {
                  // If the form is valid, display a snackbar. In the real world,
                  // you'd often call a server or save the information in a database.
                  ScaffoldMessenger.of(context)
                      .showSnackBar(SnackBar(content: Text('Processing Data')));
                }else{
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => LoginPage()),);
                }
              },
                child: Text('SIGN UP'),
            ),
          ),
        ],
      ),
    );
  }
}