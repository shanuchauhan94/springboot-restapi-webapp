const myForm = document.querySelector("form")
const name = document.getElementById("name")
const email = document.getElementById("email")
const dob = document.getElementById("dob")
const mobile = document.getElementById("mobile")
const city = document.getElementById("city")
const village = document.getElementById("village")
const pinCode = document.getElementById("pinCode")
const gender = document.getElementById("gender")
const password = document.getElementById("password")

myForm.addEventListener("submit", onsubmit);

function onsubmit(e) {
  e.preventDefault();
  fetch('http://localhost:9090/app/estate/agent/register', {
    method: 'POST',
    body: JSON.stringify({
      name: name.value,
      email: email.value,
      dob: dob.value,
      mobNumber: mobile.value,
      city: city.value,
      village: village.value,
      pinCode: pinCode.value,
      gender: gender.value,
      password: password.value
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
      'Access-Control-Allow-Origin': 'http://localhost:9000'
    }
  }).then(function (response) {
    return response.json()
  }).then(function (data) {
    const ul = document.getElementById("data")
    const li = document.createElement("li");
    li.appendChild(document.createTextNode(`${data.agent_Id} | ${data.name} |  ${data.email} | ${data.mobNumber}`))
    ul.appendChild(li);
  }).catch(error => console.error('Error:', error));

  /*  const msg = document.querySelector(".msg")
    msg.style.display = "block";
    msg.textContent = "All fields are mandatory."*/

}

