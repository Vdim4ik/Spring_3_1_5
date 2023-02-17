let formNew = document.forms["formForNewUser"];

function addNewUser() {
    formNew.addEventListener("submit", ev => {
        ev.preventDefault();
        let newUserRoles = [];
        for (let i = 0; i < formNew.roles.options.length; i++) {
            if (formNew.roles.options[i].selected) {
                newUserRoles.push({
                    id: formNew.roles.value,
                    name: "ROLE_" + formNew.roles.options[i].text
                });
            }
        }
        console.log(newUserRoles)
        fetch('admin/api/new', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: formNew.email.value,
                firstName: formNew.firstName.value,
                lastName: formNew.lastName.value,
                age: formNew.age.value,
                password: formNew.password.value,
                roles: newUserRoles
            })
        }).then(() => {
            getUserTable();
            $('#all-tab').click();
        });
    });
}

addNewUser();
