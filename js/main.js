const apiBase = "http://localhost:8000/api/store"

document.addEventListener("DOMContentLoaded", fetchItems)

function fetchItems() {
    fetch(apiBase)
        .then(res => res.json())
        .then(items => {
            const body = document.getElementById("itemTableBody")
            body.innerHTML = ""
            var counter = 0;
            items.forEach(item => {
                body.innerHTML += `
              <tr class="text-center">
                <td class="border p-2">${++counter}</td>
                <td class="border p-2">${item.name}</td>
                <td class="border p-2">${item.description}</td>
                <td class="border p-2">${item.stock}</td>
                <td class="border p-2">${item.unit}</td>
                <td class="border p-2">${item.price}</td>
                <td class="border p-2">
                  <button onclick="openEditModal(${item.id}, '${item.name}', '${item.description}', ${item.stock}, '${item.unit}', ${item.price})" class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">Edit</button>
                  <button onclick="deleteCar(${item.id})" class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">Delete</button>
                </td>
              </tr>`
            })
        })
        .catch(err => console.error(err))
}

function openCreateModal() {
    document.getElementById("itemForm").reset()
    document.getElementById("itemId").value = ""
    document.getElementById("modalTitle").innerText = "Add Car"
    document.getElementById("itemModal").classList.remove("hidden")
}

function openEditModal(id, name, description, stock, unit, price) {
    document.getElementById("itemId").value = id
    document.getElementById("itemName").value = name
    document.getElementById("itemDescription").value = description
    document.getElementById("itemStock").value = stock
    document.getElementById("itemUnit").value = unit
    document.getElementById("itemPrice").value = price
    document.getElementById("modalTitle").innerText = "Edit Item"
    document.getElementById("itemModal").classList.remove("hidden")
}

function closeModal() {
    document.getElementById("itemModal").classList.add("hidden")
}

function saveItem(e) {
    e.preventDefault()
    const id = document.getElementById("itemId").value
    const name = document.getElementById("itemName").value
    const description = document.getElementById("itemDescription").value
    const stock = document.getElementById("itemStock").value
    const unit = document.getElementById("itemUnit").value
    const price = document.getElementById("itemPrice").value

    const item = { name, description, stock, unit, price }
    const method = id ? "PUT" : "POST"
    const url = id ? `${apiBase}/${id}` : apiBase

    fetch(url, {
        method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item)
    })
        .then(res => res.json())
        .then(() => {
            closeModal()
            fetchItems()
        })
        .catch(err => console.error(err))
}

function deleteItem(id) {
    if (!confirm("Delete this item?")) return
    fetch(`${apiBase}/${id}`, { method: "DELETE" })
        .then(() => fetchItems())
        .catch(err => console.error(err))
}
