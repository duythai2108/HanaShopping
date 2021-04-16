
<%-- 
    Document   : cart
    Created on : Oct 12, 2020, 10:35:10 PM
    Author     : Duy Thai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="supports-js supports-svg supports-supports supports-placeholder supports-no-touchevents supports-csstransforms supports-csstransforms3d" lang="en" style="">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="theme-color" content="">
        <link rel="canonical" href="https://simpletheme-light.myshopify.com/cart">


        <link rel="shortcut icon" href="img/fav-logo2.jpg" type="image/jpg">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>


        <title>
            Your Shopping Cart – Simple
        </title>



        <!-- /snippets/social-meta-tags.liquid -->




        <meta property="og:site_name" content="Simple">
        <meta property="og:url" content="https://simpletheme-light.myshopify.com/cart">
        <meta property="og:title" content="Your Shopping Cart">
        <meta property="og:type" content="website">
        <meta property="og:description" content="Demo store for the Simple ecommerce theme by and for Shopify">





        <meta name="twitter:site" content="@shopify">

        <meta name="twitter:card" content="summary_large_image">
        <meta name="twitter:title" content="Your Shopping Cart">
        <meta name="twitter:description" content="Demo store for the Simple ecommerce theme by and for Shopify">


        <script type="text/javascript" async="" src="css/s/javascripts/tricorder/trekkie.storefront.min.js?v=2020.07.13.1"></script>
        <script>
            document.documentElement.className = document.documentElement.className.replace('supports-no-js', 'supports-js');
            var theme = {
                mapStrings: {
                    addressError: "Error looking up that address",
                    addressNoResults: "No results for that address",
                    addressQueryLimit: "You have exceeded the Google API usage limit. Consider upgrading to a \u003ca href=\"https:\/\/developers.google.com\/maps\/premium\/usage-limits\"\u003ePremium Plan\u003c\/a\u003e.",
                    authError: "There was a problem authenticating your Google Maps account."
                }
            }
        </script>

        <link href="css/s/files/t2assets/theme.scss.css?v=14165163854940617624" rel="stylesheet" type="text/css" media="all">

        <meta id="shopify-digital-wallet" name="shopify-digital-wallet" content="/26208075798/digital_wallets/dialog">
        <link href="https://monorail-edge.shopifysvc.com" rel="dns-prefetch">

        <script async="" src="css/s/assets/shop_events_listener-d81deda6557a113fbcc6a993184828adcef6f241e4ca52b6a21169cb03169317.js"></script>
        <script integrity="sha256-GkS6D0JfVvFoaxmvX+T8Owz974xJVdRRDQbxbJf9Nmg=" data-source-attribution="shopify.loadfeatures" defer="defer" src="css/s/assets/storefront/load_feature-1a44ba0f425f56f1686b19af5fe4fc3b0cfdef8c4955d4510d06f16c97fd3668.js" crossorigin="anonymous"></script>
        <script integrity="sha256-h+g5mYiIAULyxidxudjy/2wpCz/3Rd1CbrDf4NudHa4=" data-source-attribution="shopify.dynamic-checkout" defer="defer" src="css/s/assets/storefront/features-87e8399988880142f2c62771b9d8f2ff6c290b3ff745dd426eb0dfe0db9d1dae.js" crossorigin="anonymous"></script>

        <script src="css/s/files/t2assets/jquery-1.11.0.min.js?v=3246042684083249002" type="text/javascript"></script>
        <script src="css/s/files/t2assets/modernizr.min.js?v=4404443942060959132" type="text/javascript"></script>

        <script src="css/s/files/t2assets/lazysizes.min.js?v=15522312340271661705" async="async"></script>


        <meta property="og:image" content="css/s/files/1/0262/0807/5798/files/logo.png?height=628&amp;pad_color=fff&amp;v=1588362785&amp;width=1200">
        <meta property="og:image:secure_url" content="css/s/files/1/0262/0807/5798/files/logo.png?height=628&amp;pad_color=fff&amp;v=1588362785&amp;width=1200">
        <meta property="og:image:width" content="1200">
        <meta property="og:image:height" content="628">
        <script type="module" defer="" src="css/shopifycloud/consent-tracking-api/v0.1/consent-tracking-api.js"></script>
        <link href="css/shopifycloud/boomerang/shopify-boomerang-1.0.0.min.js" rel="preload" as="script">
        <script id="boomr-scr-as" src="css/shopifycloud/boomerang/shopify-boomerang-1.0.0.min.js" async=""></script>
        <script src="chrome-extension://mooikfkahbdckldjjndioackbalphokd/assets/prompt.js"></script>

    </head>

    <body id="your-shopping-cart" class="template-cart">

        <a class="in-page-link visually-hidden skip-link" href="#MainContent">Skip to content</a>

        <div id="shopify-section-header" class="shopify-section">

            <style>
                .site-header__logo {
                    width: 150px;
                }

                #HeaderLogoWrapper {
                    max-width: 350px !important;
                }
            </style>
            <div class="page-border"></div>

            <div class="site-wrapper">
                <div class="top-bar grid">

                    <div class="grid__item medium-up--one-fifth small--one-half">
                        <div class="top-bar__search">
                            <a href="search" class="medium-up--hide">
                                <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-search" viewBox="0 0 20 20">
                                <path fill="#444"
                                      d="M18.64 17.02l-5.31-5.31c.81-1.08 1.26-2.43 1.26-3.87C14.5 4.06 11.44 1 7.75 1S1 4.06 1 7.75s3.06 6.75 6.75 6.75c1.44 0 2.79-.45 3.87-1.26l5.31 5.31c.45.45 1.26.54 1.71.09.45-.36.45-1.17 0-1.62zM3.25 7.75c0-2.52 1.98-4.5 4.5-4.5s4.5 1.98 4.5 4.5-1.98 4.5-4.5 4.5-4.5-1.98-4.5-4.5z">
                                </path>
                                </svg>
                            </a>
                            <form action="MainController" method="get" class="search-bar small--hide" role="search">

                                <button type="submit" name="btnAction" value="Search" class="search-bar__submit">
                                    <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-search"
                                         viewBox="0 0 20 20">
                                    <path fill="#444"
                                          d="M18.64 17.02l-5.31-5.31c.81-1.08 1.26-2.43 1.26-3.87C14.5 4.06 11.44 1 7.75 1S1 4.06 1 7.75s3.06 6.75 6.75 6.75c1.44 0 2.79-.45 3.87-1.26l5.31 5.31c.45.45 1.26.54 1.71.09.45-.36.45-1.17 0-1.62zM3.25 7.75c0-2.52 1.98-4.5 4.5-4.5s4.5 1.98 4.5 4.5-1.98 4.5-4.5 4.5-4.5-1.98-4.5-4.5z">
                                    </path>
                                    </svg>
                                    <span class="icon__fallback-text">Search</span>
                                </button>
                                <input type="search" name="txtSearcg" class="search-bar__input" value="" placeholder="Search" aria-label="Search">
                            </form>
                        </div>
                    </div>



                    <div class="grid__item  medium-up--four-fifths  small--one-half text-right">
                        <a href="cart.jsp" class="site-header__cart">
                            <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-cart" viewBox="0 0 20 20">
                            <path fill="#444"
                                  d="M18.936 5.564c-.144-.175-.35-.207-.55-.207h-.003L6.774 4.286c-.272 0-.417.089-.491.18-.079.096-.16.263-.094.585l2.016 5.705c.163.407.642.673 1.068.673h8.401c.433 0 .854-.285.941-.725l.484-4.571c.045-.221-.015-.388-.163-.567z">
                            </path>
                            <path fill="#444"
                                  d="M17.107 12.5H7.659L4.98 4.117l-.362-1.059c-.138-.401-.292-.559-.695-.559H.924c-.411 0-.748.303-.748.714s.337.714.748.714h2.413l3.002 9.48c.126.38.295.52.942.52h9.825c.411 0 .748-.303.748-.714s-.336-.714-.748-.714zM10.424 16.23a1.498 1.498 0 1 1-2.997 0 1.498 1.498 0 0 1 2.997 0zM16.853 16.23a1.498 1.498 0 1 1-2.997 0 1.498 1.498 0 0 1 2.997 0z">
                            </path>
                            </svg>

                            <span class="small--hide">
                                Cart
                                (<span id="CartCount">${sessionScope.CARTCOUNT}

                                </span>)
                            </span>

                        </a>
                    </div>
                </div>

                <hr class="small--hide hr--border">

                <header class="site-header grid medium-up--grid--table" role="banner">
                    <div class="grid__item small--text-center">
                        <div itemscope="" itemtype="http://schema.org/Organization">


                            <div id="HeaderLogoWrapper" class="supports-js">
                                <a href="MainController?btnAction=Search&txtSearch=" itemprop="url" style="padding-top:30.30888030888031%; display: block;">
                                    <img id="HeaderLogo" class="lazyautosizes lazyloaded" src="img/logo.png" alt="Hana Shopping">
                                </a>
                            </div>

                        </div>
                    </div>

                </header>
            </div>




        </div>



        <div class="site-wrapper">

            <div class="grid">

                <div id="shopify-section-sidebar" class="shopify-section">
                    <div data-section-id="sidebar" data-section-type="sidebar-section">
                        <nav class="grid__item small--text-center medium-up--one-fifth" role="navigation">
                            <hr class="hr--small medium-up--hide">
                            <button id="ToggleMobileMenu" class="mobile-menu-icon medium-up--hide" aria-haspopup="true" aria-owns="SiteNav">
                                <span class="line"></span>
                                <span class="line"></span>
                                <span class="line"></span>
                                <span class="line"></span>
                                <span class="icon__fallback-text">Menu</span>
                            </button>
                            <div id="SiteNav" class="site-nav" role="menu">
                                <ul class="list--nav">



                                    <li class="site-nav__item">
                                        <a href="MainController?btnAction=Search&txtSearch=" class="site-nav__link">Home</a>
                                    </li>

                                    <!-- 
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/accessories" class="site-nav__link">Accessories</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/denim" class="site-nav__link">Denim</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/footwear" class="site-nav__link">Footwear</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/jeans" class="site-nav__link">Jeans</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/outerwear" class="site-nav__link">Outerwear</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/pants" class="site-nav__link">Pants</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/shirts" class="site-nav__link">Shirts</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/t-shirts" class="site-nav__link">T-Shirts</a>
                                    </li>
    
    
    
    
                                    <li class="site-nav__item">
                                        <a href="/collections/shorts" class="site-nav__link">Shorts</a>
                                    </li>
                                    -->


                                </ul>
                                <ul class="list--inline social-links">

                                    <li>
                                        <a href="https://www.facebook.com/shopify" title="Simple on Facebook">
                                            <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-facebook" viewBox="0 0 20 20">
                                            <path fill="#444"
                                                  d="M18.05.811q.439 0 .744.305t.305.744v16.637q0 .439-.305.744t-.744.305h-4.732v-7.221h2.415l.342-2.854h-2.757v-1.83q0-.659.293-1t1.073-.342h1.488V3.762q-.976-.098-2.171-.098-1.634 0-2.635.964t-1 2.72V9.47H7.951v2.854h2.415v7.221H1.413q-.439 0-.744-.305t-.305-.744V1.859q0-.439.305-.744T1.413.81H18.05z">
                                            </path>
                                            </svg>
                                            <span class="icon__fallback-text">Facebook</span>
                                        </a>
                                    </li>


                                    <li>
                                        <a href="https://twitter.com/shopify" title="Simple on Twitter">
                                            <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-twitter" viewBox="0 0 20 20">
                                            <path fill="#444"
                                                  d="M19.551 4.208q-.815 1.202-1.956 2.038 0 .082.02.255t.02.255q0 1.589-.469 3.179t-1.426 3.036-2.272 2.567-3.158 1.793-3.963.672q-3.301 0-6.031-1.773.571.041.937.041 2.751 0 4.911-1.671-1.284-.02-2.292-.784T2.456 11.85q.346.082.754.082.55 0 1.039-.163-1.365-.285-2.262-1.365T1.09 7.918v-.041q.774.408 1.773.448-.795-.53-1.263-1.396t-.469-1.864q0-1.019.509-1.997 1.487 1.854 3.596 2.924T9.81 7.184q-.143-.509-.143-.897 0-1.63 1.161-2.781t2.832-1.151q.815 0 1.569.326t1.284.917q1.345-.265 2.506-.958-.428 1.386-1.732 2.18 1.243-.163 2.262-.611z">
                                            </path>
                                            </svg>
                                            <span class="icon__fallback-text">Twitter</span>
                                        </a>
                                    </li>



                                    <li>
                                        <a href="https://instagram.com/shopify" title="Simple on Instagram">
                                            <svg aria-hidden="true" focusable="false" role="presentation" class="icon icon-instagram" viewBox="0 0 512 512">
                                            <path
                                                d="M256 49.5c67.3 0 75.2.3 101.8 1.5 24.6 1.1 37.9 5.2 46.8 8.7 11.8 4.6 20.2 10 29 18.8s14.3 17.2 18.8 29c3.4 8.9 7.6 22.2 8.7 46.8 1.2 26.6 1.5 34.5 1.5 101.8s-.3 75.2-1.5 101.8c-1.1 24.6-5.2 37.9-8.7 46.8-4.6 11.8-10 20.2-18.8 29s-17.2 14.3-29 18.8c-8.9 3.4-22.2 7.6-46.8 8.7-26.6 1.2-34.5 1.5-101.8 1.5s-75.2-.3-101.8-1.5c-24.6-1.1-37.9-5.2-46.8-8.7-11.8-4.6-20.2-10-29-18.8s-14.3-17.2-18.8-29c-3.4-8.9-7.6-22.2-8.7-46.8-1.2-26.6-1.5-34.5-1.5-101.8s.3-75.2 1.5-101.8c1.1-24.6 5.2-37.9 8.7-46.8 4.6-11.8 10-20.2 18.8-29s17.2-14.3 29-18.8c8.9-3.4 22.2-7.6 46.8-8.7 26.6-1.3 34.5-1.5 101.8-1.5m0-45.4c-68.4 0-77 .3-103.9 1.5C125.3 6.8 107 11.1 91 17.3c-16.6 6.4-30.6 15.1-44.6 29.1-14 14-22.6 28.1-29.1 44.6-6.2 16-10.5 34.3-11.7 61.2C4.4 179 4.1 187.6 4.1 256s.3 77 1.5 103.9c1.2 26.8 5.5 45.1 11.7 61.2 6.4 16.6 15.1 30.6 29.1 44.6 14 14 28.1 22.6 44.6 29.1 16 6.2 34.3 10.5 61.2 11.7 26.9 1.2 35.4 1.5 103.9 1.5s77-.3 103.9-1.5c26.8-1.2 45.1-5.5 61.2-11.7 16.6-6.4 30.6-15.1 44.6-29.1 14-14 22.6-28.1 29.1-44.6 6.2-16 10.5-34.3 11.7-61.2 1.2-26.9 1.5-35.4 1.5-103.9s-.3-77-1.5-103.9c-1.2-26.8-5.5-45.1-11.7-61.2-6.4-16.6-15.1-30.6-29.1-44.6-14-14-28.1-22.6-44.6-29.1-16-6.2-34.3-10.5-61.2-11.7-27-1.1-35.6-1.4-104-1.4z">
                                            </path>
                                            <path
                                                d="M256 126.6c-71.4 0-129.4 57.9-129.4 129.4s58 129.4 129.4 129.4 129.4-58 129.4-129.4-58-129.4-129.4-129.4zm0 213.4c-46.4 0-84-37.6-84-84s37.6-84 84-84 84 37.6 84 84-37.6 84-84 84z">
                                            </path>
                                            <circle cx="390.5" cy="121.5" r="30.2"></circle>
                                            </svg>
                                            <span class="icon__fallback-text">Instagram</span>
                                        </a>
                                    </li>








                                </ul>
                            </div>
                            <hr class="medium-up--hide hr--small ">
                        </nav>
                    </div>




                </div>

                <main class="main-content grid__item medium-up--four-fifths" id="MainContent" role="main">

                    <hr class="hr--border-top small--hide">


                    <nav class="breadcrumb-nav small--text-center" aria-label="You are here">
                        <span itemscope="" itemtype="http://schema.org/BreadcrumbList">
                            <span itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                <a href="MainController?btnAction=Search&txtSearch=" itemprop="item" title="Back to the frontpage">
                                    <span itemprop="name">Home</span>
                                </a>
                                <span itemprop="position" hidden="">1</span>
                            </span>
                            <span class="breadcrumb-nav__separator" aria-hidden="true">›</span>

                            <span itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                                <span itemprop="name">Your Shopping Cart</span>
                                <span itemprop="position" hidden="">2</span>
                            </span>

                        </span>
                    </nav>


                    <!-- /templates/cart.liquid -->


                    <div class="grid">
                        <div class="grid__item">
                            <h1 class="h2 visually-hidden">Shopping Cart</h1>

                            <c:if test="${sessionScope.CART != null}">
                                <c:if test="${not empty CART}">
                                    <table class="cart-table responsive-table table--no-border">
                                        <thead class="cart__row cart__header-labels small--hide">
                                            <tr>
                                                <th class="text-left cart__table-cell--image">Product</th>
                                                <th class="text-center cart__table-cell--meta"></th>
                                                <th class="text-right cart__table-cell--price">Price</th>
                                                <th class="text-right cart__table-cell--quantity">Quantity</th>
                                                <th class="text-right cart__table-cell--line-price">Total</th>
                                                <th class="text-right cart__table-cell--line-price">Update</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="total" value="0"/>
                                            <c:forEach var="dto" items="${sessionScope.CART.cart}" varStatus="counter">
                                                <c:set var="total" value="${pageScope.total +(dto.value.quantity * dto.value.price)}"/>
                                            <form action="MainController"  method="GET" novalidate="" class="cart">
                                                <tr class="cart__row responsive-table__row">
                                                    <td class="cart__table-cell--image small--text-center">

                                                        <style>
                                                            #CartImage--4733548036118 {
                                                                max-width: 720px;
                                                                max-height: 720.0px;
                                                            }

                                                            #CartImageWrapper--4733548036118 {
                                                                max-width: 720px;
                                                            }
                                                        </style>

                                                        <div id="CartImageWrapper--4733548036118" class="cart__image-wrapper supports-js" >
                                                            <a class="cart__image-container" style="padding-top:100.0%;">
                                                                <img id="CartImage--4733548036118" class="cart__image lazyautosizes lazyloaded" src="img/product/${dto.value.image}" data-widths="[180, 230, 360, 540, 720, 900, 1080, 1296, 1512, 1728, 2048]" data-aspectratio="1.0"
                                                                     data-sizes="auto" alt="${dto.value.productName}" itemprop="image"
                                                                     sizes="145px" width="150px" height="130px" >
                                                            </a>

                                                        </div>
                                                        <input type="hidden" name="txtProductID" value="${dto.value.productID}">

                                                        <noscript>
                                                        <a

                                                            <img class="cart__image"
                                                             src="img/product/${dto.value.image}"
                                                             alt="${dto.value.productName}">
                                                        </a>
                                                        </noscript>
                                                    </td>
                                                    <td class="cart__table-cell--meta text-center large-up--text-left">
                                                        <p>
                                                            <a ${dto.value.productID}>${dto.value.productName}</a>

   
                                                        </p>

                                                        <p class="txt--minor">
                                                            <a onclick="return confirm('Are you sure you want to Delete product ?')" href="MainController?btnAction=DeleteCart&txtProductID=${dto.value.productID}" class="cart__remove">Remove</a>
                                                        </p>
                                                    </td>
                                                    <td class="cart__table-cell--price medium-up--text-right" data-label="Price">
                                                        $${dto.value.price}

                                                    </td>
                                                    <td data-label="Quantity" class="medium-up--text-right cart__table-cell--quantity">
                                                        <label class="visually-hidden" for="updates_31363498606614:9d522a393549565fec48477473403bf3">Quantity</label>
                                                        <input class="quantity-selector" type="number" name="txtQuantity" id="update" value="${dto.value.quantity}" min="1">
                                                    </td>
                                                    <td data-label="Total" class="text-right cart__table-cell--line-price">
                                                        $${dto.value.quantity * dto.value.price}
                                                    </td>
                                                    <td>
                                                        <p>
                                                            <button type="submit" name="btnAction" value="UpdateCart" class="btn btn--secondary update-cart">
                                                                <svg aria-h idden="true" focusable="false" role="presentation"
                                                                     class="icon icon-update" viewBox="0 0 25 25">
                                                                <path
                                                                    d="M22.339 1.386a1.606 1.606 0 0 0-1.743 1.458l-.077.875A12.124 12.124 0 0 0 12.211.456C5.478.456 0 5.933 0 12.666s5.478 12.212 12.211 12.212c4.653 0 8.84-2.587 10.923-6.748a1.606 1.606 0 1 0-2.872-1.438 8.959 8.959 0 0 1-8.051 4.973c-4.962 0-8.999-4.035-8.999-8.998 0-4.961 4.037-8.999 8.999-8.999a8.93 8.93 0 0 1 6.172 2.452l-1.292-.115a1.604 1.604 0 0 0-1.741 1.458 1.605 1.605 0 0 0 1.457 1.742l4.799.426a1.601 1.601 0 0 0 1.742-1.458l.448-5.045a1.607 1.607 0 0 0-1.457-1.742z">
                                                                </path>
                                                                </svg>
                                                                <span class="icon__fallback-text">Update Cart</span>
                                                            </button>
                                                        </p>
                                                    </td>
                                                </tr>
                                            </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                    <footer class="cart__footer">
                                        <div class="grid">
                                            <div class="grid__item large-up--one-half">
                                                <label for="CartSpecialInstructions" class="label--block">Special instructions
                                                    for seller</label>
                                                <textarea name="note" id="CartSpecialInstructions" class="input--block cart__note"></textarea>
                                            </div>
                                            <div class="grid__item text-center large-up--one-half large-up--text-right">
                                                <p>
                                                    <span class="cart__subtotal-title h3">Subtotal </span>
                                                    <span class="cart__subtotal h3">$${pageScope.total}</span>
                                                </p>
                                                <p class="cart__policies txt--emphasis rte">Taxes and shipping calculated at checkout
                                                </p>
                                                <p>

                                                    <button type="submit" name="btnAcion" value="UpdateCart" class="btn btn--secondary update-cart">

                                                        <svg aria-hidden="true" focusable="false" role="presentation"
                                                             class="icon icon-update" viewBox="0 0 25 25">
                                                        <path
                                                            d="M22.339 1.386a1.606 1.606 0 0 0-1.743 1.458l-.077.875A12.124 12.124 0 0 0 12.211.456C5.478.456 0 5.933 0 12.666s5.478 12.212 12.211 12.212c4.653 0 8.84-2.587 10.923-6.748a1.606 1.606 0 1 0-2.872-1.438 8.959 8.959 0 0 1-8.051 4.973c-4.962 0-8.999-4.035-8.999-8.998 0-4.961 4.037-8.999 8.999-8.999a8.93 8.93 0 0 1 6.172 2.452l-1.292-.115a1.604 1.604 0 0 0-1.741 1.458 1.605 1.605 0 0 0 1.457 1.742l4.799.426a1.601 1.601 0 0 0 1.742-1.458l.448-5.045a1.607 1.607 0 0 0-1.457-1.742z">
                                                        </path>
                                                        </svg>
                                                        <span class="icon__fallback-text">Update Cart</span>
                                                    </button>
                                                    <a class="btn btn--secondary" href="MainController?btnAction=Search&txtSearch=">Continue shopping</a>
                                                </p>
                                                <p>
                                                    <a href="information.jsp">
                                                        <button class="btn">
                                                            Check Out
                                                        </button>
                                                    </a>
                                                    <br>
                                                    <script
                                                        src="https://www.paypal.com/sdk/js?client-id=AT6qrwApNOycr7du3HyhXBdBY-3ArfkRe97bKoYlH_ZF7MN8vMjinAk_IOPyfTQL7Dcidh9O9qj8_RQX"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.
                                                    </script>

                                                <div id="paypal-button-container"></div>


                                                <script>
                                                    paypal.Buttons({
                                                        createOrder: function (data, actions) {
                                                            return actions.order.create({
                                                                purchase_units: [{
                                                                        amount: {
                                                                            value: '100.01'
                                                                        }
                                                                    }]
                                                            });
                                                        },
                                                        // Finalize the transaction
                                                        onApprove: function (data, actions) {
                                                            return actions.order.capture().then(function (details) {
                                                                // Show a success message to the buyer
//                                                                alert('Transaction completed by ' + details.payer.name.given_name + '!');
                                                                // window.location.href="MainController?btnAction=Search&txtSearch="
                                                                Swal.fire({
                                                                    title: 'Thanks For Purchase.',
                                                                    width: 600,
                                                                    padding: '3em',
                                                                    background: '#fff url(https://sweetalert2.github.io/images/trees.png)',
                                                                    backdrop: `
    rgba(0,0,123,0.4)
    url("https://sweetalert2.github.io/images/nyan-cat.gif")
    left top
    no-repeat
  `,
                                                                    confirmButtonColor: '#3085d6',
                                                                    confirmButtonText: 'OK'
                                                                }).then((result) => {
                                                                    if (result.isConfirmed) {
//                                                                        Swal.fire(
//                                                                                'Deleted!',
//                                                                                'Your file has been deleted.',
//                                                                                'success'
//                                                                                )
 window.location.href="MainController?btnAction=Search&txtSearch="
                                                                    }
                                                                })

                                                            });
                                                        }


                                                    }).render('#paypal-button-container');
                                                </script>
                                                </p>
                                            </div>
                                        </div>
                                    </footer>
                                </c:if>
                            </c:if>
                        </div>
                    </div>

                </main>

            </div>

            <hr>

            <div id="shopify-section-footer" class="shopify-section">
                <footer class="site-footer" role="contentinfo" data-section-id="footer" data-section-type="footer-section">

                    <div class="grid">

                        <div class="grid__item medium-up--one-half small--one-whole">

                            <h3 class="site-footer__section-title">Links</h3>

                            <ul class="site-footer__menu">

                                <li><a href="/search">Search</a></li>

                                <li><a href="/pages/about-us">Our story</a></li>

                                <li><a href="/blogs/news">News</a></li>

                                <li><a href="/pages/contact-us">Contact Us</a></li>

                            </ul>
                        </div>




                        <div class="grid__item medium-up--one-half small--one-whole">

                            <h3 class="site-footer__section-title">Be in the know</h3>
                            <form method="post" action="/contact#contact_form" id="contact_form" accept-charset="UTF-8" class="contact-form"><input type="hidden" name="form_type" value="customer"><input type="hidden" name="utf8" value="✓">


                                <input type="hidden" name="contact[tags]" value="newsletter">
                                <label for="NewsletterEmail" class="newsletter-label">

                                    <div class="rte">
                                        <p>Promotions, new products and sales. Directly to your inbox.</p>
                                    </div>

                                </label>
                                <div class="input-group">
                                    <input type="email" value="" placeholder="Your email" name="contact[email]" id="NewsletterEmail" class="input-group__field site-footer__newsletter-input" autocorrect="off" autocapitalize="off">
                                    <div class="input-group__btn">
                                        <button type="submit" class="btn" name="commit" id="Subscribe">
                                            <span>Subscribe</span>

                                        </button>
                                    </div>
                                </div>

                            </form>

                        </div>




                    </div>


                    <hr>


                    <div class="grid medium-up--grid--table sub-footer small--text-center">
                        <div class="grid__item medium-up--one-half">
                            <small>Copyright © 2020, <a href="/" title="">Simple</a>. <a target="_blank" rel="nofollow"
                                                                                         href="https://www.shopify.com?utm_campaign=poweredby&amp;utm_medium=shopify&amp;utm_source=onlinestore">Powered
                                    by Shopify</a></small>
                        </div>
                        <div class="grid__item medium-up--one-half medium-up--text-right">
                            <span class="visually-hidden">Payment icons</span>
                            <ul class="list--inline payment-icons">
                                <li>
                                    <svg class="icon icon--full-color" viewBox="0 0 38 24" xmlns="http://www.w3.org/2000/svg" role="img" width="38" height="24" aria-labelledby="pi-visa">
                                    <title id="pi-visa">Visa</title>
                                    <path opacity=".07"
                                          d="M35 0H3C1.3 0 0 1.3 0 3v18c0 1.7 1.4 3 3 3h32c1.7 0 3-1.3 3-3V3c0-1.7-1.4-3-3-3z">
                                    </path>
                                    <path fill="#fff"
                                          d="M35 1c1.1 0 2 .9 2 2v18c0 1.1-.9 2-2 2H3c-1.1 0-2-.9-2-2V3c0-1.1.9-2 2-2h32">
                                    </path>
                                    <path
                                        d="M28.3 10.1H28c-.4 1-.7 1.5-1 3h1.9c-.3-1.5-.3-2.2-.6-3zm2.9 5.9h-1.7c-.1 0-.1 0-.2-.1l-.2-.9-.1-.2h-2.4c-.1 0-.2 0-.2.2l-.3.9c0 .1-.1.1-.1.1h-2.1l.2-.5L27 8.7c0-.5.3-.7.8-.7h1.5c.1 0 .2 0 .2.2l1.4 6.5c.1.4.2.7.2 1.1.1.1.1.1.1.2zm-13.4-.3l.4-1.8c.1 0 .2.1.2.1.7.3 1.4.5 2.1.4.2 0 .5-.1.7-.2.5-.2.5-.7.1-1.1-.2-.2-.5-.3-.8-.5-.4-.2-.8-.4-1.1-.7-1.2-1-.8-2.4-.1-3.1.6-.4.9-.8 1.7-.8 1.2 0 2.5 0 3.1.2h.1c-.1.6-.2 1.1-.4 1.7-.5-.2-1-.4-1.5-.4-.3 0-.6 0-.9.1-.2 0-.3.1-.4.2-.2.2-.2.5 0 .7l.5.4c.4.2.8.4 1.1.6.5.3 1 .8 1.1 1.4.2.9-.1 1.7-.9 2.3-.5.4-.7.6-1.4.6-1.4 0-2.5.1-3.4-.2-.1.2-.1.2-.2.1zm-3.5.3c.1-.7.1-.7.2-1 .5-2.2 1-4.5 1.4-6.7.1-.2.1-.3.3-.3H18c-.2 1.2-.4 2.1-.7 3.2-.3 1.5-.6 3-1 4.5 0 .2-.1.2-.3.2M5 8.2c0-.1.2-.2.3-.2h3.4c.5 0 .9.3 1 .8l.9 4.4c0 .1 0 .1.1.2 0-.1.1-.1.1-.1l2.1-5.1c-.1-.1 0-.2.1-.2h2.1c0 .1 0 .1-.1.2l-3.1 7.3c-.1.2-.1.3-.2.4-.1.1-.3 0-.5 0H9.7c-.1 0-.2 0-.2-.2L7.9 9.5c-.2-.2-.5-.5-.9-.6-.6-.3-1.7-.5-1.9-.5L5 8.2z"
                                        fill="#142688"></path>
                                    </svg>
                                </li>
                                <li>
                                    <svg class="icon icon--full-color" viewBox="0 0 38 24" xmlns="http://www.w3.org/2000/svg" role="img" width="38" height="24" aria-labelledby="pi-master">
                                    <title id="pi-master">Mastercard</title>
                                    <path opacity=".07"
                                          d="M35 0H3C1.3 0 0 1.3 0 3v18c0 1.7 1.4 3 3 3h32c1.7 0 3-1.3 3-3V3c0-1.7-1.4-3-3-3z">
                                    </path>
                                    <path fill="#fff"
                                          d="M35 1c1.1 0 2 .9 2 2v18c0 1.1-.9 2-2 2H3c-1.1 0-2-.9-2-2V3c0-1.1.9-2 2-2h32">
                                    </path>
                                    <circle fill="#EB001B" cx="15" cy="12" r="7"></circle>
                                    <circle fill="#F79E1B" cx="23" cy="12" r="7"></circle>
                                    <path fill="#FF5F00"
                                          d="M22 12c0-2.4-1.2-4.5-3-5.7-1.8 1.3-3 3.4-3 5.7s1.2 4.5 3 5.7c1.8-1.2 3-3.3 3-5.7z">
                                    </path>
                                    </svg>
                                </li>
                                <li>
                                    <svg class="icon icon--full-color" xmlns="http://www.w3.org/2000/svg" role="img" viewBox="0 0 38 24" width="38" height="24" aria-labelledby="pi-american_express">
                                    <title id="pi-american_express">American Express</title>
                                    <g fill="none">
                                    <path fill="#000"
                                          d="M35,0 L3,0 C1.3,0 0,1.3 0,3 L0,21 C0,22.7 1.4,24 3,24 L35,24 C36.7,24 38,22.7 38,21 L38,3 C38,1.3 36.6,0 35,0 Z"
                                          opacity=".07"></path>
                                    <path fill="#006FCF"
                                          d="M35,1 C36.1,1 37,1.9 37,3 L37,21 C37,22.1 36.1,23 35,23 L3,23 C1.9,23 1,22.1 1,21 L1,3 C1,1.9 1.9,1 3,1 L35,1">
                                    </path>
                                    <path fill="#FFF"
                                          d="M8.971,10.268 L9.745,12.144 L8.203,12.144 L8.971,10.268 Z M25.046,10.346 L22.069,10.346 L22.069,11.173 L24.998,11.173 L24.998,12.412 L22.075,12.412 L22.075,13.334 L25.052,13.334 L25.052,14.073 L27.129,11.828 L25.052,9.488 L25.046,10.346 L25.046,10.346 Z M10.983,8.006 L14.978,8.006 L15.865,9.941 L16.687,8 L27.057,8 L28.135,9.19 L29.25,8 L34.013,8 L30.494,11.852 L33.977,15.68 L29.143,15.68 L28.065,14.49 L26.94,15.68 L10.03,15.68 L9.536,14.49 L8.406,14.49 L7.911,15.68 L4,15.68 L7.286,8 L10.716,8 L10.983,8.006 Z M19.646,9.084 L17.407,9.084 L15.907,12.62 L14.282,9.084 L12.06,9.084 L12.06,13.894 L10,9.084 L8.007,9.084 L5.625,14.596 L7.18,14.596 L7.674,13.406 L10.27,13.406 L10.764,14.596 L13.484,14.596 L13.484,10.661 L15.235,14.602 L16.425,14.602 L18.165,10.673 L18.165,14.603 L19.623,14.603 L19.647,9.083 L19.646,9.084 Z M28.986,11.852 L31.517,9.084 L29.695,9.084 L28.094,10.81 L26.546,9.084 L20.652,9.084 L20.652,14.602 L26.462,14.602 L28.076,12.864 L29.624,14.602 L31.499,14.602 L28.987,11.852 L28.986,11.852 Z">
                                    </path>
                                    </g>
                                    </svg>

                                </li>
                                <li>
                                    <svg class="icon icon--full-color" viewBox="0 0 38 24" xmlns="http://www.w3.org/2000/svg" width="38" height="24" role="img" aria-labelledby="pi-paypal">
                                    <title id="pi-paypal">PayPal</title>
                                    <path opacity=".07"
                                          d="M35 0H3C1.3 0 0 1.3 0 3v18c0 1.7 1.4 3 3 3h32c1.7 0 3-1.3 3-3V3c0-1.7-1.4-3-3-3z">
                                    </path>
                                    <path fill="#fff"
                                          d="M35 1c1.1 0 2 .9 2 2v18c0 1.1-.9 2-2 2H3c-1.1 0-2-.9-2-2V3c0-1.1.9-2 2-2h32">
                                    </path>
                                    <path fill="#003087"
                                          d="M23.9 8.3c.2-1 0-1.7-.6-2.3-.6-.7-1.7-1-3.1-1h-4.1c-.3 0-.5.2-.6.5L14 15.6c0 .2.1.4.3.4H17l.4-3.4 1.8-2.2 4.7-2.1z">
                                    </path>
                                    <path fill="#3086C8"
                                          d="M23.9 8.3l-.2.2c-.5 2.8-2.2 3.8-4.6 3.8H18c-.3 0-.5.2-.6.5l-.6 3.9-.2 1c0 .2.1.4.3.4H19c.3 0 .5-.2.5-.4v-.1l.4-2.4v-.1c0-.2.3-.4.5-.4h.3c2.1 0 3.7-.8 4.1-3.2.2-1 .1-1.8-.4-2.4-.1-.5-.3-.7-.5-.8z">
                                    </path>
                                    <path fill="#012169"
                                          d="M23.3 8.1c-.1-.1-.2-.1-.3-.1-.1 0-.2 0-.3-.1-.3-.1-.7-.1-1.1-.1h-3c-.1 0-.2 0-.2.1-.2.1-.3.2-.3.4l-.7 4.4v.1c0-.3.3-.5.6-.5h1.3c2.5 0 4.1-1 4.6-3.8v-.2c-.1-.1-.3-.2-.5-.2h-.1z">
                                    </path>
                                    </svg>
                                </li>
                                <li>
                                    <svg class="icon icon--full-color" viewBox="0 0 38 24" xmlns="http://www.w3.org/2000/svg" role="img" width="38" height="24" aria-labelledby="pi-diners_club">
                                    <title id="pi-diners_club">Diners Club</title>
                                    <path opacity=".07"
                                          d="M35 0H3C1.3 0 0 1.3 0 3v18c0 1.7 1.4 3 3 3h32c1.7 0 3-1.3 3-3V3c0-1.7-1.4-3-3-3z">
                                    </path>
                                    <path fill="#fff"
                                          d="M35 1c1.1 0 2 .9 2 2v18c0 1.1-.9 2-2 2H3c-1.1 0-2-.9-2-2V3c0-1.1.9-2 2-2h32">
                                    </path>
                                    <path
                                        d="M12 12v3.7c0 .3-.2.3-.5.2-1.9-.8-3-3.3-2.3-5.4.4-1.1 1.2-2 2.3-2.4.4-.2.5-.1.5.2V12zm2 0V8.3c0-.3 0-.3.3-.2 2.1.8 3.2 3.3 2.4 5.4-.4 1.1-1.2 2-2.3 2.4-.4.2-.4.1-.4-.2V12zm7.2-7H13c3.8 0 6.8 3.1 6.8 7s-3 7-6.8 7h8.2c3.8 0 6.8-3.1 6.8-7s-3-7-6.8-7z"
                                        fill="#3086C8"></path>
                                    </svg>
                                </li>
                                <li>
                                    <svg class="icon icon--full-color" xmlns="http://www.w3.org/2000/svg" role="img" viewBox="0 0 38 24" width="38" height="24" aria-labelledby="pi-discover">
                                    <title id="pi-discover">Discover</title>
                                    <path
                                        d="M35 0H3C1.3 0 0 1.3 0 3v18c0 1.7 1.4 3 3 3h32c1.7 0 3-1.3 3-3V3c0-1.7-1.4-3-3-3z"
                                        fill="#000" opacity=".07"></path>
                                    <path
                                        d="M35 1c1.1 0 2 .9 2 2v18c0 1.1-.9 2-2 2H3c-1.1 0-2-.9-2-2V3c0-1.1.9-2 2-2h32"
                                        fill="#FFF"></path>
                                    <path d="M37 16.95V21c0 1.1-.9 2-2 2H23.228c7.896-1.815 12.043-4.601 13.772-6.05z"
                                          fill="#EDA024"></path>
                                    <path fill="#494949" d="M9 11h20v2H9z"></path>
                                    <path d="M22 12c0 1.7-1.3 3-3 3s-3-1.4-3-3 1.4-3 3-3c1.7 0 3 1.3 3 3z"
                                          fill="#EDA024"></path>
                                    </svg>

                                </li>
                            </ul>
                        </div>
                    </div>
                </footer>




            </div>
        </div>



        <ul hidden="">
            <li id="a11y-refresh-page-message">Choosing a selection results in a full page refresh.</li>
            <li id="a11y-selection-message">Press the space key then arrow keys to make a selection.</li>
        </ul>

        <script src="css/s/files/t2assets/theme.js?v=13733231539381766514" type="text/javascript"></script>


    </body>

</html>
