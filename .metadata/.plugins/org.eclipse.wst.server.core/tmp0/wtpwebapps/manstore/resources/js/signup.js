var checkID = false;
var checkNAME = false;
var checkPWD = false;
var checkBIRTH = false;
var checkEMAIL = false;
var checkADDR = false;
var checkPHONE = false;

$(function() {
	$("#user_id").keyup(function() {
		IDChk();
	});
	
	$("#user_name").keyup(function() {
		NAMEChk();
	})

	$("#user_pwd").keyup(function() {
		PWDChk();
	})

	$("#user_pwd_chk").keyup(function() {
		PWDChk();
	})

	if ($("#birth_year").val() != "") {
		BIRChk();
	}

	$("#birth_year").blur(function() {
		BIRChk();
	});
	
	$("#birth_month").blur(function() {
		BIRChk();
	});
	
	$("#birth_day").blur(function() {
		BIRChk();
	});
	
	$("#email_select").change(function() {
		if ($("#email_select").val() == "1") {
			$("#email_addr").val("");
			$("#email_addr").prop("disabled", false);
		} else if ($("#email_select").val() == "") {
			if ($("#email_id").val() == "") {
				$("#email_addr").val("");
				$("#email_addr").prop("disabled", true);
				$("#emchk").css("color", "red");
				$("#emchk").text("필수항목입니다.");
				checkEMAIL = false;
			} else {
				$("#email_addr").val("");
				$("#email_addr").prop("disabled", true);
				$("#emchk").css("color", "red");
				$("#emchk").text("주소값이 비었습니다..");
				checkEMAIL = false;
			}
		} else {
			if ($("#email_id").val() == "") {
				$("#email_addr").val($("#email_select").val());
				$("#email_addr").prop("disabled", true);
				$("#emchk").css("color", "red");
				$("#emchk").text("아이디가 공백입니다.");
				checkEMAIL = false;
			} else {
				$("#email_addr").val($("#email_select").val());
				$("#email_addr").prop("disabled", true);
				$("#emchk").text("");
				checkEMAIL = true;
			}
		}
	});
	
	$("#email_id").keyup(function() {
		EMChk();
	});
	
	$("#email_addr").keyup(function() {
		EMChk();
	});
	
	$("#address2").blur(function() {
		if ($("#address2").val() == "") {
			$("#adchk").css("color", "red");
			$("#adchk").text("상세주소를 입력해주세요");
			checkADDR = false;
		} else {
			$("#adchk").text("");
			checkADDR = true;
		}
	});
	
	$("#phone_1").change(function() {
		PHOChk();
	});
	
	$("#phone_2").keyup(function() {
		PHOChk();
	});
	
	$("#phone_3").keyup(function() {
		PHOChk();
	});
	
	$("input[name=interest]").click(function() {
		if ($("input[name=interest]:checked").length == 3) {
			$("input[name=interest]:not(:checked)").prop("disabled", true);
		} else {
			$("input[name=interest]:not(:checked)").prop("disabled", false);
		}
	});
});

function IDChk() {
	var user_id = $("#user_id").val();
	if (user_id == "") {
		$("#idchk").css("color", "red");
		$("#idchk").text("필수 항목입니다.");
		checkID = false;
	} else {
		$.ajax({
			type : "POST",
			url : "checkID",
			data : {
				"user_id" : user_id
			},
			success : function(data) {
				if (data == 0) {
					$("#idchk").css("color", "green");
					$("#idchk").text("사용 가능한 아이디입니다.");
					checkID = true;
				} else if (data != 0) {
					$("#idchk").css("color", "red");
					$("#idchk").text("이미 존재하는 아이디입니다.");
					checkID = false;
				}
			}
		});
	}
}

function NAMEChk() {
	var oMsg = $("#namechk");
	var nonchar = /[^가-힣a-zA-Z]/gi;
	
	var name = $("#user_name").val();
	if (name == "") {
		oMsg.css("color", "red");
		oMsg.text("필수정보입니다.");
		return false;
	}
	
	if (name != "" && nonchar.test(name)) {
		oMsg.css("color", "red");
		oMsg.text("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
		return false;
	}
	checkNAME = true;
	oMsg.text("");
	return true;
}

function PWDChk() {
	var user_pwd = $("#user_pwd").val();
	var user_pwd_chk = $("#user_pwd_chk").val();
	if (user_pwd == "" && user_pwd_chk == "") {
		$("#pw1chk").css("color", "red");
		$("#pw1chk").text("필수 항목입니다.");
		$("#pw2chk").css("color", "red");
		$("#pw2chk").text("필수 항목입니다.");
	} else if (user_pwd == "" && user_pwd_chk != "") {
		$("#pw1chk").css("color", "red");
		$("#pw1chk").text("필수 항목입니다.");
		$("#pw2chk").css("color", "red");
		$("#pw2chk").text("비밀번호가 동일하지 않습니다.");
		checkPWD = false;
	} else if ((user_pwd != "" && user_pwd_chk != "")
			&& (user_pwd != user_pwd_chk)) {
		$("#pw1chk").text("");
		$("#pw2chk").css("color", "red");
		$("#pw2chk").text("비밀번호가 동일하지 않습니다.");
		checkPWD = false;
	} else if ((user_pwd != "" && user_pwd_chk != "")
			&& (user_pwd == user_pwd_chk)) {
		$("#pw1chk").text("");
		$("#pw2chk").css("color", "green");
		$("#pw2chk").text("비밀번호가 동일합니다.");
		checkPWD = true;
	} else {
		$("#pw1chk").text("");
		checkPWD = false;
	}
}

function BIRChk() {
	var birthDay;
	var yy = $("#birth_year").val();
	var mm = $("#birth_month").val();
	var dd = $("#birth_day").val();
	var oMsg = $("#birchk");

	if (yy == "" && mm == "" && dd == "") {
		oMsg.css("color", "red");
		oMsg.text("태어난 년도 4자리를 정확히 입력해주세요");
		return false;
	}

	if (mm.length == 1) {
		mm = "0" + mm;
	}

	if (dd.length == 1) {
		dd = "0" + dd;
	}

	if (yy == "") {
		oMsg.css("color", "red");
		oMsg.text("태어난 년도를 선택하세요");
		return false;
	}

	if (mm == "") {
		oMsg.css("color", "red");
		oMsg.text("태어난 월을 선택하세요");
		return false;
	}

	if (dd == "") {
		oMsg.css("color", "red");
		oMsg.text("태어난 일(날짜) 2자리를 정확히 입력하세요.");
		return false;
	}

	if (dd.length != 2 || dd.indexOf('e') != -1 || dd.indexOf('E') != -1) {
		oMsg.css("color", "red");
		oMsg.text("태어난 일(날짜) 2자리를 정확히 입력하세요.");
		return false;
	}

	birthDay = yy + mm + dd;
	if (!isValidDate(birthDay)) {
		oMsg.css("color", "red");
		oMsg.text("생년월일을 다시 확인해주세요.");
		return false;
	}

	var age = calcAge(birthDay);

	if (age < 0) {
		oMsg.css("color", "red");
		oMsg.text("외계인이신가요");
		return false;
	} else if (age >= 100) {
		oMsg.css("color", "red");
		oMsg.text("정말이신가요?");
		return false;
	} else if (age < 14) {
		oMsg.css("color", "red");
		oMsg.text("만 14세 미만의 어린이는 가입할 수 없습니다.");
		return false;
	} else {
		checkBIRTH = true;
		oMsg.text("");
		return true;
	}
	checkBIRTH = true;
	return true;
}

function calcAge(birth) {
	var date = new Date();
	var year = date.getFullYear();
	var month = (date.getMonth() + 1);
	var day = date.getDate();
	if (month < 10) {
		month = "0" + month;
	}
	if (day < 10) {
		day = "0" + day;
	}
	var monthDay = month + "" + day;

	birth = birth.replace("-", "").replace("-", "");
	var birthdayy = birth.substr(0, 4);
	var birthdaymd = birth.substr(4, 4);

	var age = monthDay < birthdaymd ? year - birthdayy - 1 : year - birthdayy;
	return age;
}

function isValidDate(param) {
	try {
		param = param.replace(/-/g, "");

		if (isNaN(param) || param.length != 8) {
			return false;
			checkBIRTH = false;
		}

		var year = Number(param.substring(0, 4));
		var month = Number(param.substring(4, 6));
		var day = Number(param.substring(6, 8));

		if (month < 1 || month > 12) {
			return false;
			checkBIRTH = false;
		}

		var maxDaysInMonth = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ];
		var maxDay = maxDaysInMonth[month - 1];

		if (month == 2 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) {
			maxDay = 29;
		}

		if (day <= 0 || day > maxDay) {
			return false;
			checkBIRTH = false;
		}
		return true;
		checkBIRTH = true;
	} catch (err) {
		checkBIRTH = false;
	}
}

function EMChk() {
	var email_id=$("#email_id").val();
	var email_addr=$("#email_addr").val();
	
	if (email_id == "" && email_addr == "") {
		$("#emchk").css("color", "red");
		$("#emchk").text("필수항목입니다.");
		checkEMAIL = false;
	} else if(email_id == "") {
		$("#emchk").css("color", "red");
		$("#emchk").text("아이디가 공백입니다.");
		checkEMAIL = false;
	} else if (email_addr == "") {
		$("#emchk").css("color", "red");
		$("#emchk").text("주소값이 공백입니다.");
		checkEMAIL = false;
	} else {
		$("#emchk").text("");
		checkEMAIL = true;
	}
}

function searchPost() {
	new daum.Postcode({
		oncomplete : function(data) {
			var fullAddr = '';
			var extraAddr = '';

			if (data.userSelectedType == 'R') {
				fullAddr = data.roadAddress;
			} else {
				fullAddr = data.jibunAddress;
			}
			if (data.userSelectedType == 'R') {
				if (data.bname !== '') {
					extraAddr += data.bname;
				}
				if (data.buildingName !== '') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				fullAddr += (extraAddr !== '' ? '(' + extraAddr + ')' : '');
			}
			$("#zipcode").val(data.zonecode);
			$("#address1").val(fullAddr);
			$("#address2").prop("disabled", false);
			$("#address2").focus();
		}
	}).open();
}

function onlyNumber(){
	if((event.keyCode<48)||(event.keyCode>57)) {
		event.returnValue=false;
	}
}

function PHOChk() {
	var phone_1=$("#phone_1").val();
	var phone_2=$("#phone_2").val();
	var phone_3=$("#phone_3").val();
	if(phone_1 == "" || phone_2.length != 4 || phone_3.length != 4) {
		$("#phonechk").css("color", "red");
		$("#phonechk").text("연락처를 확인해주세요");
		checkPHONE=false;
	} else {
		$("#phonechk").text("");
		checkPHONE=true;
	}
}

function signupFn() {
	var user_id=$("#user_id").val();
	var user_name=$("#user_name").val();
	var user_pwd=$("#user_pwd").val();
	var user_birth=$("#birth_year").val()+"-"+$("#birth_month").val()+"-"+$("#birth_day").val();
	var email=$("#email_id").val() + "@" + $("#email_addr").val();
	var zipcode=$("#zipcode").val();
	var address1=$("#address1").val();
	var address2=$("#address2").val();
	var phone=$("#phone_1").val() + "-" + $("#phone_2").val() + "-" + $("#phone_3").val(); 
	var interest = "";
	if ($("input[name=interest]:checked").length == 0) {
		interest = "";
	} else {
		$("input[name=interest]:checked").each(function() {
			interest += $(this).val() + ",";
		});
	}
	
	if(checkID == false || checkNAME == false || checkPWD == false || 
			checkBIRTH == false || checkEMAIL == false || 
			checkADDR == false || checkPHONE == false) {
		swal("", "필수항목이 비어있습니다.", "warning");
	} else {
		$.ajax({
			type : "POST", 
			url : "signup",
			data : {
				"user_id" : user_id,
				"user_name" : user_name,
				"user_pwd" : user_pwd,
				"user_birth" : user_birth,
				"email" : email,
				"zipcode" : zipcode,
				"address1" : address1,
				"address2" : address2,
				"phone" : phone,
				"interest" : interest
			}, success : function(data) {
				window.location.href="main";
			}
		});
	}
	
	console.log("user_id: " + user_id
			+ ", user_name: " + user_name
			+ ", user_pwd: " + user_pwd
			+ ", user_birth: " + user_birth
			+ ", email: " + email
			+ ", zipcode: " + zipcode
			+ ", address1: " + address1
			+ ", address2: " + address2
			+ ", interest: " + interest);
}