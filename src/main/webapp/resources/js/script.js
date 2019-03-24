function playLaterToggle(gameId) {
    let icon = $("#play-later-" + gameId);
    icon.disabled = true;
    $.get("validateLogin", function (data) {
        let validateLogin = JSON.parse(data).loginned;
        if (validateLogin === true) {
            $.get("playLaterToggle?gameId=" + gameId, function (data) {
                let result = JSON.parse(data);
                if (result.on) {
                    if (!icon.hasClass("fas")) {
                        icon.addClass("fas");
                    }
                    icon.removeClass("far")
                } else {
                    if (!icon.hasClass("far")) {
                        icon.addClass("far");
                    }
                    icon.removeClass("fas");
                }
            });
            icon.disabled = false;
        } else {
            window.location.replace("/login");
        }
    });
}

function setMark(gameId, mark) {
    let icons = $("#marks-" + gameId + " .fa-star");
    icons.each(function (index, element) {
        element.disabled = true;
    });
    $.get("validateLogin", function (data) {
        let validateLogin = JSON.parse(data).loginned;
        if (validateLogin === true) {
            $.post("setMark", {gameId: gameId, mark: mark});
            icons.each(function (index, element) {
                if (index < mark) {
                    $(element).addClass("fa");
                    $(element).removeClass("far");
                } else {
                    $(element).addClass("far");
                    $(element).removeClass("fa");
                }
                element.disabled = false;
                $("#delete-mark-" + gameId).removeAttr("disabled");
            });
        } else {
            window.location.replace("/login");
        }
    });
}

function deleteMark(gameId) {
    $("delete-mark-" + gameId).attr("disabled");
    let icons = $("#marks-" + gameId + " .fa-star");
    icons.each(function (index, element) {
        $(element).addClass("far");
        $(element).removeClass("fa");
    });
    $.get("validateLogin", function (data) {
        let validateLogin = JSON.parse(data).loginned;
        if (validateLogin === true) {
            $.post("/deleteMark", {gameId: gameId});
        } else {
            window.location.replace("/login");
        }
    });
}

function hoverStars(divId, index) {
    let stars = $("#" + divId).children(".fa-star");
    for (let i = 0; i < index; ++i) {
        stars[i].classList.add('hovered-star');
    }
    for (let i = index; i<10; ++i) {
        stars[i].classList.add('unhovered-star');
    }
    $(".unhovered-star").css({"fontWeight": "400"});
    $(".hovered-star").css({"fontWeight": "900"});
}

function unhoverStars(divId, index) {
    let stars = $("#" + divId).children(".fa-star");
    $(".hovered-star").css({"fontWeight": "400"});
    $(".fa").css({"fontWeight": "900"});
    for (let i = 0; i < index; ++i) {
        stars[i].classList.remove('hovered-star');
    }
    for (let i = index; i<10; ++i) {
        stars[i].classList.remove('unhovered-star');
    }
}