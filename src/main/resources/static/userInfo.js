function getUserInfo() {
    fetch('user/api')
        .then(resp => resp.json())
        .then(data => {
            $('#nav-email').append(data.email);
            $('#nav-role').append(data.roles.map(role => " " + role.name.substring(5)));
            let userInfo = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.firstName}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>
                    <td>${data.email}</td>
                    <td>${data.roles.map(role => " " + role.name.substring(5))}</td>
                </tr>)`;
            $('#user-info').append(userInfo);
        })
}

getUserInfo();

