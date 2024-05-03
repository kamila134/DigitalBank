@Shopping
Feature: Outline Orders

  Scenario Outline: Process Online Orders
    Given there is an online order with the following details:
      | orderId       | customerName     | shippingAddress  | productName   | quantity | totalAmount |
      | <orderId>     | <customerName>  | <shippingAddress> | <productName> | <quantity> | <totalAmount> |
    When the user processes the online order, generating an invoice for following order:
      | orderId     | customerName     | shippingAddress  | productName   | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | <orderId>   | <customerName>  | <shippingAddress> | <productName> | <quantity> | <unitPrice> | <subtotal> | <taxRate> | <taxAmount> | <totalAmount> |
    Then the user should see the invoice generated for the following order:
      | orderId     | customerName     | shippingAddress  | productName   | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | <orderId>   | <customerName>  | <shippingAddress> | <productName> | <quantity> | <unitPrice> | <subtotal> | <taxRate> | <taxAmount> | <totalAmount> |

    Examples:
      | orderId | customerName | shippingAddress | productName | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | 12345   | John Doe     | 123 Main Street | Product A   | 2        | 25.00     | 50.00    | 5%      | 2.50      | 52.50       |