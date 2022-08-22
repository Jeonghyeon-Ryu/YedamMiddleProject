<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/tiles/template/header.jsp"/>
<main>
</main>
<template id="main-template" style="display:none">
	<div class="card" style="max-width:540px">
        <div class="row">
            <div class="col-md-8">
                <img src="" class="img-fluid rounded" alt="...">
                <img src="img/like-heart-35.png" class="like">
            </div>
            <div class="col-md-4">
                <div class="card-body">
                    <h5 class="card-title"></h5>
                    <div class="star-rated">
						<a class="star-1" href="#1">★</a>
						<a class="star-2" href="#2">★</a>
						<a class="star-3" href="#3">★</a>
						<a class="star-4" href="#4">★</a>
				    	<a class="star-5" href="#5">★</a>
					</div>
                    <p class="card-address"><strong>주소 :</strong></p>
                    <p class="card-text"><small class="text-muted">Last updated</small></p>
                </div>
            </div>
        </div>
    </div>
</template>
<script src="js/main.js"></script>