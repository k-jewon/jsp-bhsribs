$('.slider').slick({
    infinite: true,
    slidesToShow: 1,
    slidesToScroll: 1,
    pauseOnHover : false,
    pauseOnFocus: false,
    arrows:false,
    autoplay:true,
    dots: true
  });
  $('.slider2').slick({
    infinite: true,
    slidesToShow: 3,
    slidesToScroll: 1,
    pauseOnFocus: false,
    arrows:true,
    prevArrow:$('.prev_btn'),
    nextArrow:$('.next_btn'),
    autoplay:true,
    responsive:[
      {
        breakpoint : 1080,
        settings: {
          slidesToShow:2
        }
      },
      {
        breakpoint : 767,
        settings: {
          slidesToShow:1
        }
      },
    ]
  });