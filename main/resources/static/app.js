function mysteriousFunction() {
    console.log("what");
    return alert("why though");
}

function buildStudentTable(data){
    let tableBody = document.getElementById("allStudentsResult");
    tableBody.innerHTML = "";

    const tableHeader = `<table>
                            <tr>
                                <th> Name </th>
                                <th> Grade </th>
                            </tr>
                            <tbody>`;

    let tableRows = ``;

    for (let i = 0; i < data.length; i++) {
            let row = `<tr>
                            <td>${data[i].name}</td>
                            <td>${data[i].grade}</td>
                       </tr>`;
        tableRows += row;
        }

    const tableEnd = `</tbody>
                        </table>`;

    tableBody.innerHTML = tableHeader + tableRows + tableEnd;
}

async function findAllStudents() {
    const allStudents = await fetch("http://localhost:8082/api/student/read/all");
    const data = await allStudents.json();
    buildStudentTable(data);
}




function buildSchoolTable(data) {
let tableBody = document.getElementById("allSchoolsResult");
    tableBody.innerHTML = "";

    const tableHeader = `<table>
                            <tr>
                                <th> Name </th>
                                <th> City </th>
                                <th> Student Body Size </th>
                            </tr>
                            <tbody>`;

    let tableRows = ``;

    for (let i = 0; i < data.length; i++) {
            let row = `<tr>
                            <td>${data[i].name}</td>
                            <td>${data[i].city}</td>
                            <td>${data[i].nr_of_students}</td>
                       </tr>`;
        tableRows += row;
        }

    const tableEnd = `</tbody>
                        </table>`;

    tableBody.innerHTML = tableHeader + tableRows + tableEnd;
}

async function findAllSchools() {
    const allSchools = await fetch("http://localhost:8082/api/school/read/all");
    const data = await allSchools.json();
    buildSchoolTable(data);
}

function buildCourseTable(data) {
let tableBody = document.getElementById("allCoursesResult");
    tableBody.innerHTML = "";

    const tableHeader = `<table>
                            <tr>
                                <th> Name </th>
                                <th> Credits </th>
                            </tr>
                            <tbody>`;

    let tableRows = ``;

    for (let i = 0; i < data.length; i++) {
            let row = `<tr>
                            <td>${data[i].name}</td>
                            <td>${data[i].credits}</td>
                       </tr>`;
        tableRows += row;
        }

    const tableEnd = `</tbody>
                        </table>`;

    tableBody.innerHTML = tableHeader + tableRows + tableEnd;
}

async function findAllCourses() {
    const allCourses = await fetch("http://localhost:8082/api/course/read/all");
    const data = await allCourses.json();
    buildCourseTable(data);
}