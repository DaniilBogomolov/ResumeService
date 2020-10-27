function toogleForm(formId) {
    var forms = $(".form")
    forms.each(function () {
        $(this).attr("hidden", true)
    });
    const id = "#".concat(formId);
    $(id).removeAttr("hidden");
}