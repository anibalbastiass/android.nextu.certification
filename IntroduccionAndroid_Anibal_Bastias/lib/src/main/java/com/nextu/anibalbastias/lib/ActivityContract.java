package com.nextu.anibalbastias.lib;


interface ActivityContract {
    ActivityController showLogCat(String tagName);
    ActivityController setKey(ActivityController.Type type);
    ActivityController setMessage(int resourceId);
}
