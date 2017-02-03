
<!-- Scripts For Bootstrap DateTimePicker  End  ---->
<script src="${rc.getContextPath()}/resources/js/date_js/jquery.min.js"></script>
<script src="${rc.getContextPath()}/resources/js/date_js/moment.min.js"></script>
<script
	src="${rc.getContextPath()}/resources/js/date_js/bootstrap.min.js"></script>
<script
	src="${rc.getContextPath()}/resources/js/date_js/bootstrap-datetimepicker.min.js"></script>
<script
	src="${rc.getContextPath()}/resources/js/date_js/bootstrap-datepicker.js"></script>
<script
	src="${rc.getContextPath()}/resources/js/date_js/bootstrap-datepicker.js"></script>
<script src="${rc.getContextPath()}/resources/js/date_js/en-gb.js"></script>

<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/date/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/date/datepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${rc.getContextPath()}/resources/css/date/bootstrap.min.css">
	
	<script type="text/javascript">
	$(document).ready(function() {
		$('body').on('focus', "#duedate", function() {
			$(this).datetimepicker({
				format : 'DD-MM-YYYY',
				pickTime : false,
				autoclose : true
			});
		});
	});
</script>