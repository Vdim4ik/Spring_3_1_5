let formDelete = document.forms["formForDeleteUser"];

async function deleteModalData(email) {
    const modal = new bootstrap.Modal(document.querySelector('#deleteModal'));
    modal.show();
    let user = await getUser(email);
    formDelete.id.value = user.id;
    formDelete.firstName.value = user.firstName;
    formDelete.lastName.value = user.lastName;
    formDelete.age.value = user.age;
    formDelete.email.value = user.email;
}

function deleteUser() {
    formDelete.addEventListener("submit", ev => {
        ev.preventDefault();
        fetch('admin/api/' + formDelete.id.value, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            $('#deleteFormCloseButton').click();
            getUserTable();
        });
    });
}

deleteUser();