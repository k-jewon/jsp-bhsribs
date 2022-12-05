<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<footer>
		<div class="logo">
			<a style="color: white" href="/Project/index.jsp">북한산갈비&춘천숯불닭갈비</a>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script src="/Project/js/slick.min.js"></script>
	<script src="/Project/js/slide.js"></script>
	<script src="/Project/js/userCheck.js"></script>
	<script>
		$('.menu_bar').click(function() {
			$('.menu_bar').toggleClass('active');
			$('.menu_item').toggleClass('active');
		});
		$( '.board_line' ).click( function() {
            window.location.href = '/Project/View/BoardPage.jsp';
        } );
	</script>
</body>
</html>