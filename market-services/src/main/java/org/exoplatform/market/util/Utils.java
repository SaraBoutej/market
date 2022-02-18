package org.exoplatform.market.util;

import org.exoplatform.services.security.ConversationState;
import org.exoplatform.commons.utils.CommonsUtils;
import org.exoplatform.social.core.identity.model.Identity;
import org.exoplatform.social.core.manager.IdentityManager;

public class Utils {

  /**
   * @return id of the current user
   */
  public static final String getCurrentUser () {
    return ConversationState.getCurrent().getIdentity().getUserId();
  }

  public static Identity getIdentityByTypeAndId(String type, String name) {
    IdentityManager identityManager = CommonsUtils.getService(IdentityManager.class);
    return identityManager.getOrCreateIdentity(type, name);
  }

  public static UserInfo getUserInfo(Identity identity) {
    UserInfo userInfo = new UserInfo();
    userInfo.setId(identity.getId());
    userInfo.setRemoteId(identity.getRemoteId());
    userInfo.setFullName(identity.getProfile().getFullName());
    userInfo.setAvatarUrl(identity.getProfile().getAvatarUrl());
    return userInfo;
  }
  
}
