package com.amf.pfm.user.domain.exception

const val EMPTY_STRING = ""

const val USER_WITH_MISSING_USERNAME = "Username cannot be null or empty"
const val USER_WITH_MISSING_PASSWORD = "Password cannot be null or empty"
const val USER_WITH_MISSING_FIRST_NAME = "First name cannot be null or empty"
const val USER_WITH_MISSING_LAST_NAME = "Last name cannot be null or empty"
const val USER_USERNAME_ALREADY_EXISTS = "Username '%s' already exists"
const val USER_NOT_FOUND = "User with id '%s' has not been found"