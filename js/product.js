const apiBase = "http://localhost:8000/api/products";

document.addEventListener("DOMContentLoaded", fetchProducts);

async function fetchProducts() {
  try {
    const res = await fetch(apiBase);
    const products = await res.json();
    const body = document.getElementById("productTableBody");
    body.innerHTML = "";
    products.forEach((p, index) => {
      body.innerHTML += `
        <tr class="text-center">
          <td class="border p-2">${index + 1}</td>
          <td class="border p-2">${p.name}</td>
          <td class="border p-2">${p.description}</td>
          <td class="border p-2">${p.stock}</td>
          <td class="border p-2">${p.unit}</td>
          <td class="border p-2">₱${p.price.toFixed(2)}</td>
          <td class="border p-2">
            <button onclick="openEditModal(${p.id}, '${p.name}', '${p.description}', ${p.stock}, '${p.unit}', ${p.price})" class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">Edit</button>
            <button onclick="deleteProduct(${p.id})" class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">Delete</button>
          </td>
        </tr>`;
    });
  } catch (err) {
    console.error(err);
  }
}

function openCreateModal() {
  document.getElementById("productForm").reset();
  document.getElementById("productId").value = "";
  document.getElementById("modalTitle").innerText = "Add Product";
  document.getElementById("productModal").classList.remove("hidden");
}

function openEditModal(id, name, desc, stock, unit, price) {
  document.getElementById("productId").value = id;
  document.getElementById("productName").value = name;
  document.getElementById("productDescription").value = desc;
  document.getElementById("productStock").value = stock;
  document.getElementById("productUnit").value = unit;
  document.getElementById("productPrice").value = price;
  document.getElementById("modalTitle").innerText = "Edit Product";
  document.getElementById("productModal").classList.remove("hidden");
}

function closeModal() {
  document.getElementById("productModal").classList.add("hidden");
  document.getElementById("errorMsg").classList.add("hidden");
}

async function saveProduct(e) {
  e.preventDefault();

  const id = document.getElementById("productId").value;
  const product = {
    name: document.getElementById("productName").value,
    description: document.getElementById("productDescription").value,
    stock: parseInt(document.getElementById("productStock").value),
    unit: document.getElementById("productUnit").value,
    price: parseFloat(document.getElementById("productPrice").value)
  };

  // Client-side validation
  if (!product.name || !product.description || product.stock < 1 || !product.unit || product.price < 1) {
    const msg = document.getElementById("errorMsg");
    msg.textContent = "⚠ Please fill in all fields correctly.";
    msg.classList.remove("hidden");
    return;
  }

  const method = id ? "PUT" : "POST";
  const url = id ? `${apiBase}/${id}` : apiBase;

  try {
    const res = await fetch(url, {
      method,
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product)
    });

    if (!res.ok) {
      const errorData = await res.json();
      console.error(errorData);
      throw new Error("Server validation failed");
    }

    closeModal();
    fetchProducts();
  } catch (err) {
    console.error(err);
    alert("Error saving product. Please try again.");
  }
}

async function deleteProduct(id) {
  if (!confirm("Delete this product?")) return;
  try {
    await fetch(`${apiBase}/${id}`, { method: "DELETE" });
    fetchProducts();
  } catch (err) {
    console.error(err);
  }
}
