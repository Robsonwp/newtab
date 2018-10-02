  $(document).ready(function () {
      $('.sidenav').sidenav();
      $('.slider').slider({
          indicators: false,
          height: 500
      });
      $('.carousel').carousel({
          noWrap: true,
          dist: -30
      });
  });
