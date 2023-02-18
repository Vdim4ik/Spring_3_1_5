let formEdit = document.forms["formEditUser"];

async function updateModalData(email) {
    const modal = new bootstrap.Modal(document.querySelector('#editModal'));
    modal.show();
    let user = await getUser(email);
    formEdit.id.value = user.id;
    formEdit.firstName.value = user.firstName;
    formEdit.lastName.value = user.lastName;
    formEdit.age.value = user.age;
    formEdit.email.value = user.email;
}

function editUser() {
    formEdit.addEventListener("submit", ev => {
        ev.preventDefault();
        let editUserRoles = [];
        for (let i = 0; i < formEdit.roles.options.length; i++) {
            if (formEdit.roles.options[i].selected) {
                editUserRoles.push({
                    id: formEdit.roles.options[i].value,
                    name: "ROLE_" + formEdit.roles.options[i].text
                });
            }
        }
        fetch("admin/api/" + formEdit.id.value, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: formEdit.firstName.value,
                lastName: formEdit.lastName.value,
                age: formEdit.age.value,
                email: formEdit.email.value,
                password: formEdit.password.value,
                roles: editUserRoles
            })
        }).then(() => {
            $('#edit_close_button').click();
            getUserTable();
        });
    });
}

editUser();