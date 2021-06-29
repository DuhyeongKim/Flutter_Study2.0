import 'product.dart';

class ProductsRepository {
  static List<Product> loadProducts(Category category) {
    const allProducts = <Product>[
      Product(
        category: Category.companionTree,
        id: 0,
        name: "숲 속에 있는 듯, 소라고사리",
        price: 35000,
        description: "",
      ),
      Product(
        category: Category.companionTree,
        id: 1,
        name: "당신에게 행운을 드릴게요, 청페페",
        price: 35000,
        description: "",
      ),
      Product(
        category: Category.companionTree,
        id: 2,
        name: "유해물질 흡수에 최강, 관음죽",
        price: 35000,
        description: "",
      ),
      Product(
        category: Category.largeCompanionTree,
        id: 22,
        name: "크리스마스 트리를 닮은, 아라우카리아",
        price: 120000,
        description: "",
      ),
      Product(
        category: Category.potGardeningSupplies,
        id: 26,
        name: "해충 싹쓸이 반려나무 관리제",
        price: 8000,
        description: "",
      ),
    ];
    if (category == Category.all) {
      return allProducts;
    } else {
      return allProducts.where((Product p) {
        return p.category == category;
      }).toList();
    }
  }
}