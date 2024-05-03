

Feature: Shoe Orders

  Scenario Outline: Process Shoe Orders
    Given there is a shoe order as follows:
      | orderId       | customerName     | shippingAddress  | shoeModel   | quantity | totalAmount |
      | <orderId>     | <customerName>  | <shippingAddress> | <shoeModel> | <quantity> | <totalAmount> |
    When the user processes the shoe order, generating an invoice for the following order:
      | orderId     | customerName     | shippingAddress  | shoeModel   | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | <orderId>   | <customerName>  | <shippingAddress> | <shoeModel> | <quantity> | <unitPrice> | <subtotal> | <taxRate> | <taxAmount> | <totalAmount> |
    Then the user should see the invoice generated for the order as follows:
      | orderId     | customerName     | shippingAddress  | shoeModel   | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | <orderId>   | <customerName>  | <shippingAddress> | <shoeModel> | <quantity> | <unitPrice> | <subtotal> | <taxRate> | <taxAmount> | <totalAmount> |

    Examples:
      | orderId | customerName | shippingAddress | shoeModel | quantity | unitPrice | subtotal | taxRate | taxAmount | totalAmount |
      | 54321   | Alice Smith     | 456 Oak Avenue, Townsville | Running Shoes   | 3        | 60.00     | 100.00    | 5      | 9.00      | 189.00       |
