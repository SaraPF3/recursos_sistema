# Recursos del sistema

## Líneas que obtiene ps

----------------------------

    PID TTY          TIME CMD
  18463 pts/3    00:00:00 bash
 194511 pts/3    00:00:00 java
 194531 pts/3    00:00:00 ps

## Líneas que obtiene ds

----------------------------

Filesystem                    1K-blocks    Used Available Use% Mounted on
udev                            3983444       0   3983444   0% /dev
tmpfs                            803356     692    802664   1% /run
/dev/mapper/debian12--vg-root  23852880 5914124  16701764  27% /
tmpfs                           4016764   60692   3956072   2% /dev/shm
tmpfs                              5120       0      5120   0% /run/lock
/dev/mapper/debian12--vg-var    9509056 2722428   6282004  31% /var
/dev/sda1                        465124  211976    228214  49% /boot
/dev/mapper/debian12--vg-tmp    1880592   13508   1753216   1% /tmp
/dev/mapper/debian12--vg-home 219851752 6405388 202205712   4% /home
tmpfs                            803352      28    803324   1% /run/user/1000

## Líneas que obtiene free

----------------------------

               total        used        free      shared  buff/cache   available
Mem:         8033528     7394156      223012      110420      780040      639372
Swap:         999420      590372      409048
