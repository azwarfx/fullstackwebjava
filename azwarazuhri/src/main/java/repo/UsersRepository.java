package repo;

import entity.Users;

public abstract interface UsersRepository
{
  public abstract Users login(String paramString1, String paramString2);
}
