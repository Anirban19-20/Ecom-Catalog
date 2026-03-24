import { useEffect, useState } from 'react';
import './App.css';
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch("http://localhost:1004/api/products")
      .then(res => res.json())
      .then(data => setProducts(data));

    fetch("http://localhost:1004/api/categories")
      .then(res => res.json())
      .then(data => setCategories(data));
  }, []);

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const handleSortChange = (e) => {
    setSortOrder(e.target.value);
  };

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  };

  const filteredProducts = products
    .filter(product => {
      return (
        (selectedCategory ? product.category.id === selectedCategory : true) &&
        (
          product.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
          product.description.toLowerCase().includes(searchTerm.toLowerCase())
        )
      );
    })
    .sort((a, b) => {
      return sortOrder === "asc" ? a.price - b.price : b.price - a.price;
    });

  return (
    <div className="container">
      <h1 className="text-center my-4 fw-bold">🛍️ Product Catalog</h1>

      {/* Filters */}
      <div className="card p-3 shadow-sm mb-4">
        <div className="row g-3 align-items-center">

          <div className="col-md-3 col-sm-12">
            <CategoryFilter 
              categories={categories} 
              onSelect={handleCategorySelect}
            />
          </div>

          <div className="col-md-4 col-sm-12">
            <input
              type="text"
              className="form-control"
              placeholder="🔍 Search products..."
              value={searchTerm}
              onChange={handleSearchChange}
            />
          </div>

          <div className="col-md-3 col-sm-12">
            <select 
              className="form-select" 
              value={sortOrder} 
              onChange={handleSortChange}
            >
              <option value="asc">Price: Low → High</option>
              <option value="desc">Price: High → Low</option>
            </select>
          </div>

        </div>
      </div>

      {/* Product List */}
      <div className="row">
        {filteredProducts.length ? (
          <ProductList products={filteredProducts}/>
        ) : (
          <p className="text-center text-muted">No products found...</p>
        )}
      </div>
    </div>
  );
}

export default App;