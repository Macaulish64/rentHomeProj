$('#btn-usredit').click = function() {
  $.ajax({
    type: "POST",
    url: "rentHomeProj_war/user/edit",
    async: false,
    data: $('#form-usredit').serialize(),
  });
};