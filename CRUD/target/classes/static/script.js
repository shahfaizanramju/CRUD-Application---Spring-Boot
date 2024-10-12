// const apiUrl = 'http://localhost:8080/employees'; // Change the port if needed

// document.addEventListener('DOMContentLoaded', () => {
//     loadEmployees();

//     document.getElementById('employeeForm').addEventListener('submit', function(event) {
//         event.preventDefault();
//         const employeeId = document.getElementById('employeeId').value;
//         const employee = {
//             name: document.getElementById('employeeName').value,
//             phone: document.getElementById('employeePhone').value,
//             email: document.getElementById('employeeEmail').value
//         };

//         if (employeeId) {
//             updateEmployee(employeeId, employee);
//         } else {
//             createEmployee(employee);
//         }
//     });
// });

// function loadEmployees() {
//     fetch(apiUrl)
//         .then(response => response.json())
//         .then(data => {
//             const employeeList = document.getElementById('employeeList');
//             employeeList.innerHTML = '';
//             data.forEach(employee => {
//                 const li = document.createElement('li');
//                 li.innerHTML = `${employee.name} - ${employee.phone} - ${employee.email} 
//                     <button onclick="editEmployee(${employee.id}, '${employee.name}', '${employee.phone}', '${employee.email}')">Edit</button>
//                     <button onclick="deleteEmployee(${employee.id})">Delete</button>`;
//                 employeeList.appendChild(li);
//             });
//         });
// }

// function createEmployee(employee) {
//     fetch(apiUrl, {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(employee)
//     })
//     .then(() => {
//         loadEmployees();
//         document.getElementById('employeeForm').reset();
//     });
// }

// function editEmployee(id, name, phone, email) {
//     document.getElementById('employeeId').value = id;
//     document.getElementById('employeeName').value = name;
//     document.getElementById('employeePhone').value = phone;
//     document.getElementById('employeeEmail').value = email;
// }

// function updateEmployee(id, employee) {
//     fetch(`${apiUrl}/${id}`, {
//         method: 'PUT',
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(employee)
//     })
//     .then(() => {
//         loadEmployees();
//         document.getElementById('employeeForm').reset();
//         document.getElementById('employeeId').value = '';
//     });
// }

// function deleteEmployee(id) {
//     fetch(`${apiUrl}/${id}`, {
//         method: 'DELETE'
//     })
//     .then(() => {
//         loadEmployees();
//     });
// }