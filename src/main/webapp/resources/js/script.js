function playLaterToggle(gameId) {
    let icon = $("#play-later-" + gameId);
    icon.disabled = true;
    $.get("validateLogin", function (data, status) {
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