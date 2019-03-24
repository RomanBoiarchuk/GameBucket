function validatePassword(){
    let password = $("form[name=registration] input[name=password]");
    let confirmedPassword = $("form[name=registration] input[name=confirmedPassword]");
    if(password.val() != confirmedPassword.val()) {
        confirmedPassword[0].setCustomValidity("Passwords Don't Match");
        console.log("js gavno");
    } else {
        confirmedPassword[0].setCustomValidity('');
    }
}

function validateEmail(emailInput) {
    $.get("validateEmail?email=" + emailInput.value, function (data) {
        let exists = JSON.parse(data).emailExists;
        if (exists) {
            emailInput.setCustomValidity("Email Already Exists!");
        } else {
            emailInput.setCustomValidity('');
        }
    });
}
function validateNickname(nickNameInput) {
    $.get("validateNickname?nickname=" + nickNameInput.value, function (data) {
        let exists = JSON.parse(data).nicknameExists;
        if (exists) {
            nickNameInput.setCustomValidity("Nickname Already Exists!");
        } else {
            nickNameInput.setCustomValidity('');
        }
    });
}
function validateEntry() {
    let email = $("form[name=login] input[name=email]").val();
    let password = $("form[name=login] input[name=password]").val();
    let validate = null;
    $.ajax({
        async: false,
        type: 'GET',
        url: "validateEntry?email=" + email + "&password=" + password,
        success: function(data) {
            validate = JSON.parse(data).correct;
        }
    });
    if (!validate) {
        $("#loginError").text("Password or email is incorrect!");
    }
    return validate;
}