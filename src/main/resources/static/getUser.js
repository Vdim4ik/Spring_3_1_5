async function getUser(email) {
    const url = 'admin/api/' + email;
    let response = await fetch(url);
    return response.json();
}