Feature: Configurations


Scenario: Configure Server Parameters
  Given a new server needs to be configured
  When the server parameters are set as follows:

  | IP Address    | Server Name       | Rules and Policies     | Access Control            | Expiration Date | Responsible User | Disk Space | Server Status |
  | 192.168.1.100 | Production Server | Firewall rules applied | authorized personnel only | 2023-12-31      | John Doe         | 500 GB     | Running |
  Then the server should be successfully configured with the provided parameters