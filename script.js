// ---------- Data ----------
// Each expense: { id, title, amount, category, date }
let expenses = loadData();

// ---------- Page elements ----------
const form = document.getElementById("expense-form");
const titleInput = document.getElementById("title");
const amountInput = document.getElementById("amount");
const categoryInput = document.getElementById("category");
const dateInput = document.getElementById("date");
const errorBox = document.getElementById("error");
const listBody = document.getElementById("expense-list");
const totalSpan = document.getElementById("total");
const categoryList = document.getElementById("category-totals");

// Set today's date as the default
dateInput.value = new Date().toISOString().split("T")[0];

// ---------- Storage ----------
function loadData() {
  try {
    return JSON.parse(localStorage.getItem("expenses")) || [];
  } catch (e) {
    return [];
  }
}

function saveData() {
  try {
    localStorage.setItem("expenses", JSON.stringify(expenses));
  } catch (e) {
    console.log("Could not save data");
  }
}

// ---------- Add expense ----------
form.addEventListener("submit", function (event) {
  event.preventDefault();   // stop the page from reloading
  addExpense();
});

// Clear the old error message as soon as the user edits a field
[titleInput, amountInput, dateInput].forEach(function (el) {
  el.addEventListener("input", function () {
    errorBox.textContent = "";
  });
});

function addExpense() {
  const title = titleInput.value.trim();
  const amount = parseFloat(amountInput.value);
  const category = categoryInput.value;
  const date = dateInput.value;

  // Validation
  if (title === "") {
    errorBox.textContent = "Please enter a title.";
    return;
  }
  if (isNaN(amount) || amount <= 0) {
    errorBox.textContent = "Amount must be a number greater than 0.";
    return;
  }
  if (date === "") {
    errorBox.textContent = "Please choose a date.";
    return;
  }
  errorBox.textContent = "";

  expenses.push({
    id: Date.now(),
    title: title,
    amount: amount,
    category: category,
    date: date
  });

  saveData();
  render();

  titleInput.value = "";
  amountInput.value = "";
}

// ---------- Delete expense ----------
function deleteExpense(id) {
  expenses = expenses.filter(function (e) {
    return e.id !== id;
  });
  saveData();
  render();
}

// ---------- Totals ----------
function calculateTotals() {
  let total = 0;
  const byCategory = {};
  expenses.forEach(function (e) {
    total += e.amount;
    byCategory[e.category] = (byCategory[e.category] || 0) + e.amount;
  });
  return { total: total, byCategory: byCategory };
}

// ---------- Show everything on the page ----------
function render() {
  // Table rows
  listBody.innerHTML = "";
  expenses.forEach(function (e) {
    const row = document.createElement("tr");

    [e.title, "Rs. " + e.amount.toFixed(2), e.category, e.date].forEach(function (text) {
      const cell = document.createElement("td");
      cell.textContent = text;
      row.appendChild(cell);
    });

    const actionCell = document.createElement("td");
    const btn = document.createElement("button");
    btn.textContent = "Delete";
    btn.addEventListener("click", function () {
      deleteExpense(e.id);
    });
    actionCell.appendChild(btn);
    row.appendChild(actionCell);

    listBody.appendChild(row);
  });

  // Totals
  const result = calculateTotals();
  totalSpan.textContent = result.total.toFixed(2);

  categoryList.innerHTML = "";
  Object.keys(result.byCategory).forEach(function (cat) {
    const li = document.createElement("li");
    li.textContent = cat + ": Rs. " + result.byCategory[cat].toFixed(2);
    categoryList.appendChild(li);
  });
}

// Show saved data when the page opens
render();