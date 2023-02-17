function getUserTable() {
    $('#user-table').empty();
    fetch('admin/api')
        .then(res => res.json())
        .then(data => {
            data.forEach(user => {
                let usersTable = `$(
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.age}</td>   
                            <td>${user.email}</td>
                            <td>${user.roles.map(role => " " + role.name.substring(5))}</td>
                            <td>
                                <button type="button" class="btn btn-info"
                                data-toggle="modal"
                                data-target="#editModal"
                                onclick="updateModalData('${user.email}')">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" 
                                data-toggle="modal"
                                data-target="#deleteModal"
                                onclick="deleteModalData('${user.email}')">Delete</button>
                            </td>
                        </tr>)`;
                $('#user-table').append(usersTable);
            })
        })
}

getUserTable();