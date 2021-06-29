import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

import 'product.dart';
import 'products_repository.dart';
import 'detail.dart';

final saved = <Product>{};

class ProductPage extends StatefulWidget {
  @override
  _ProductPageState createState() => _ProductPageState();
}

class _ProductPageState extends State<ProductPage> {
  int _isSelected = 0;
  Color color0 = Colors.purpleAccent;
  Color color1 = Colors.black;
  Color color2 = Colors.black;
  Color color3 = Colors.black;
  Category _selected = Category.all;
  int _selectedIndex = 1;
  final formatCurrency = new NumberFormat.simpleCurrency(
    locale: "ko_KR",
    name: "",
    decimalDigits: 0,
  );

  List<GestureDetector> _buildList(BuildContext context, Category c) {
    List<Product> products = ProductsRepository.loadProducts(c);

    if (products == null || products.isEmpty) {
      return const <GestureDetector>[];
    }

    return products.map((product) {
      return GestureDetector(
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => DetailPage(),
              settings: RouteSettings(arguments: products[product.id]),
            ),
          );
        },
        child: Card(
          child: Padding(
            padding: EdgeInsets.all(10.0),
            child: Row(
              children: [
                Container(
                  width: 100.0,
                  height: 100.0,
                  child: Image.asset(
                    product.assetName,
                    fit: BoxFit.cover,
                  ),
                ),
                SizedBox(width: 10.0),
                Flexible(
                  child: Column(
                    children: <Widget>[
                      Align(
                        alignment: Alignment.centerLeft,
                        child: Text(
                          product.name,
                          style: TextStyle(fontWeight: FontWeight.bold),
                        ),
                      ),
                      Align(
                        alignment: Alignment.centerLeft,
                        child: Text(
                          formatCurrency.format(product.price) + "원",
                          style: TextStyle(fontWeight: FontWeight.bold),
                        ),
                      ),
                      Align(
                        alignment: Alignment.centerRight,
                        child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                            primary: Colors.greenAccent,
                          ),
                          onPressed: () {
                            if (!saved.contains(product)) {
                              saved.add(product);
                            }
                          },
                          child: Icon(
                            Icons.shopping_cart_outlined,
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      );
    }).toList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white70,
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.fixed,
        backgroundColor: Colors.white70,
        selectedItemColor: Colors.indigoAccent,
        unselectedItemColor: Colors.grey,
        currentIndex: _selectedIndex,
        onTap: (int index) {
          setState(() {
            switch (index) {
              case 0:
                Navigator.pushNamed(context, '/home');
                break;
              case 1:
                Navigator.pushNamed(context, '/product');
                break;
              // case 2:
              //   Navigator.pushNamed(context, '/detail');
              //   break;
            }
          });
        },
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home_outlined),
            label: '홈',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.grid_view),
            label: '상품',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.shopping_cart_outlined),
            label: '중고거래',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.message_outlined),
            label: '게시판',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: '내 정보',
          ),
        ],
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Container(
            padding: EdgeInsets.fromLTRB(30.0, 30.0, 0.0, 20.0),
            width: 275.0,
            child: Text(
              "내 공간에 한 그루\n숲에 또 한 그루",
              style: TextStyle(fontSize: 30.0, fontWeight: FontWeight.bold),
              maxLines: 2,
            ),
          ),
          Container(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ButtonTheme(
                  minWidth: 150.0,
                  child: ElevatedButton(
                    onPressed: () {
                      setState(() {
                        _isSelected = 0;
                        color0 = Colors.purpleAccent;
                        color1 = Colors.black;
                        color2 = Colors.black;
                        color3 = Colors.black;
                        _selected = Category.all;
                      });
                    },
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        if (_isSelected == 0)
                          Icon(
                            Icons.check,
                            color: Colors.blue,
                          ),
                        Text(
                          "전체",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                    style: ElevatedButton.styleFrom(
                      primary: color0,
                    ),
                  ),
                ),
                ButtonTheme(
                  minWidth: 150.0,
                  child: ElevatedButton(
                    onPressed: () {
                      setState(() {
                        _isSelected = 1;
                        color0 = Colors.black;
                        color1 = Colors.purpleAccent;
                        color2 = Colors.black;
                        color3 = Colors.black;
                        _selected = Category.companionTree;
                      });
                    },
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        if (_isSelected == 1)
                          Icon(
                            Icons.check,
                            color: Colors.blue,
                          ),
                        Text(
                          "반려나무",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                    style: ElevatedButton.styleFrom(
                      primary: color1,
                    ),
                  ),
                ),
              ],
            ),
          ),
          Container(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ButtonTheme(
                  minWidth: 150.0,
                  child: ElevatedButton(
                    onPressed: () {
                      setState(() {
                        _isSelected = 2;
                        color0 = Colors.black;
                        color1 = Colors.black;
                        color2 = Colors.purpleAccent;
                        color3 = Colors.black;
                        _selected = Category.largeCompanionTree;
                      });
                    },
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        if (_isSelected == 2)
                          Icon(
                            Icons.check,
                            color: Colors.blue,
                          ),
                        Text(
                          "대형 반려나무",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                    style: ElevatedButton.styleFrom(
                      primary: color2,
                    ),
                  ),
                ),
                ButtonTheme(
                  minWidth: 150.0,
                  child: ElevatedButton(
                    onPressed: () {
                      setState(() {
                        _isSelected = 3;
                        color0 = Colors.black;
                        color1 = Colors.black;
                        color2 = Colors.black;
                        color3 = Colors.purpleAccent;
                        _selected = Category.potGardeningSupplies;
                      });
                    },
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        if (_isSelected == 3)
                          Icon(
                            Icons.check,
                            color: Colors.blue,
                          ),
                        Text(
                          "화분/가드닝 용품",
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],
                    ),
                    style: ElevatedButton.styleFrom(
                      primary: color3,
                    ),
                  ),
                ),
              ],
            ),
          ),
          Expanded(
            child: ListView(
              padding: EdgeInsets.all(10.0),
              children: _buildList(context, _selected),
            ),
          ),
        ],
      ),
    );
  }
}
