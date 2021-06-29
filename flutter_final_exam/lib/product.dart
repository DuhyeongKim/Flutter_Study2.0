import 'package:flutter/foundation.dart';

enum Category {
  all,
  companionTree,
  largeCompanionTree,
  potGardeningSupplies,
}

class Product {
  const Product({
    @required this.category,
    @required this.id,
    @required this.name,
    @required this.price,
    @required this.description,
  })  : assert(category != null),
        assert(id != null),
        assert(name != null),
        assert(price != null),
        assert(description != null);

  final Category category;
  final int id;
  final String name;
  final int price;
  final String description;

  String get assetName => 'images/$id-0.jpg';
}
