package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super("Server is not accessible for now.");
        }

        public ServerNotAccessibleException(Throwable cause) {
            super("Server is not accessible for now.", cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super("User is not authorized.");
        }

        public UnauthorizedUserException(Throwable cause) {
            super("User is not authorized.", cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super("User is banned.");
        }

        public BannedUserException(Throwable cause) {
            super("User is banned.", cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super("Access is denied.");
        }

        public RestrictionException(Throwable cause) {
            super("Access is denied.", cause);
        }
    }
    public static final class Constants{
       public static final Solution.ServerNotAccessibleException SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = new Solution().new ServerNotAccessibleException();
       public static final Solution.UnauthorizedUserException USER_IS_NOT_AUTHORIZED = new Solution().new UnauthorizedUserException();
       public static final Solution.BannedUserException USER_IS_BANNED = new Solution().new BannedUserException();
       public static final Solution.RestrictionException ACCESS_IS_DENIED =  new Solution().new RestrictionException();
    }
    public static void main(String[] args) {

    }
}
