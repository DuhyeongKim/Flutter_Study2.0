/// Flutter code sample for ExpansionPanelList

// Here is a simple example of how to implement ExpansionPanelList.

import 'package:flutter/material.dart';

/// This is the main application widget.
class Search extends StatelessWidget {
  const Search({key}) : super(key: key);


  static const String _title = 'Search';

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: _title,
      home: Scaffold(
        appBar: AppBar(title: const Text(_title)),
        body: const MyStatefulWidget(),
      ),
    );
  }
}

// stores ExpansionPanel state information
class Item {
  Item({
    this.expandedValue,
    this.headerValue,
    this.isExpanded = false,
  });

  String expandedValue;
  String headerValue;
  bool isExpanded;
}

class LabeledCheckbox extends StatelessWidget {
  const LabeledCheckbox({
    Key key,
    this.label,
    this.padding,
    this.value,
    this.onChanged,
  }) : super(key: key);

  final String label;
  final EdgeInsets padding;
  final bool value;
  final Function onChanged;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        onChanged(!value);
      },
      child: Padding(
        padding: padding,
        child: Row(
          children: <Widget>[
            Expanded(child: Text(label)),
            Checkbox(
              value: value,
              onChanged: (bool newValue) {
                onChanged(newValue);
              },
            ),
          ],
        ),
      ),
    );
  }
}
List<Item> generateItems(int numberOfItems) {
  return List<Item>.generate(numberOfItems, (int index) {
    return Item(
      headerValue: 'Filter',
      expandedValue: 'This is item number $index',
    );
  });
}

/// This is the stateful widget that the main application instantiates.
class MyStatefulWidget extends StatefulWidget {

  const MyStatefulWidget({key}) : super(key: key);


  @override
  _MyStatefulWidgetState createState() => _MyStatefulWidgetState();
}

/// This is the private State class that goes with MyStatefulWidget.
class _MyStatefulWidgetState extends State<MyStatefulWidget> {
  bool _isSelected = false;
  final List<Item> _data = generateItems(1);

  @override
  Widget build(BuildContext context) {
    return ListView(
      padding: const EdgeInsets.all(8),
      children: <Widget>[
        _buildPanel(),

      ]
      );
  }


  Widget _buildPanel() {
    return ExpansionPanelList(
      expansionCallback: (int index, bool isExpanded) {
        setState(() {
          _data[index].isExpanded = !isExpanded;
        });
      },
      children: _data.map<ExpansionPanel>((Item item) {
        return ExpansionPanel(
          headerBuilder: (BuildContext context, bool isExpanded) {
            return ListTile(
              title: Text(item.headerValue),
            );
          },
          body:
            LabeledCheckbox(
            padding: const EdgeInsets.symmetric(horizontal: 20.0),
            onChanged: (bool newValue) {
              setState(() {
                _isSelected = newValue;
              });
            },
            label: 'This is the label text',
            value: _isSelected,
          ),

          isExpanded: item.isExpanded,
        );
      }).toList(),
    );
  }
}
