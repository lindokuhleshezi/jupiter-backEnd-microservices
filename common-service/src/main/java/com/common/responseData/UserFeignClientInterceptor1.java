package com.common.responseData;

//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//
//@Component
//public class UserFeignClientInterceptor implements RequestInterceptor {
//    private static final String AUTHORIZATION_HEADER = "Authorization";
//    private static final String BEARER_TOKEN_TYPE = "Bearer";
//    private final OAuth2AuthorizedClientService clientService;
//
//    public UserFeignClientInterceptor(OAuth2AuthorizedClientService clientService) {
//        this.clientService = clientService;
//    }
//
//    @Override
//    public void apply(RequestTemplate template) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//        OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(
//                oauthToken.getAuthorizedClientRegistrationId(),
//                oauthToken.getName());
//
//        OAuth2AccessToken accessToken = client.getAccessToken();
//        template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, accessToken.getTokenValue()));
//    }
//}