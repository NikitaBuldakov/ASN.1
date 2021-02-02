# ASN.1
This project implements ASN.1 data block length encoding / decoding classes

The BER standard for ASN1 notation uses TLV (Tag-Length-Value) encoding of values, while the length is encoded according to the following rules:

Length octets: There are two forms: short (for lengths between 0 and 127), and long definite (for lengths between 0 and 2 ^ 1008 -1).
• Short form. One octet. Bit 8 has value "0" and bits 7-1 give the length.
• Long form. Two to 127 octets. Bit 8 of first octet has value "1" and bits 7-1 give the number of additional length octets. Second and following octets give the length, base 256, most significant digit first.
Since the maximum block length is quite large, it was decided to use BigInteger as the data structure. The encoding itself is implemented using standard BigInteger methods.
