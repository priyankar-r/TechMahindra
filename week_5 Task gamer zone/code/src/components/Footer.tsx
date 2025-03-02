import { Box, Text } from "@chakra-ui/react";
function Footer() {
  return (
    <Box bg="#1a1a1a" color="gray.400" py={4} textAlign="center" mt={10} _hover={{ bg: "#2a2a2a", transition: "0.3s" }}>
      <Text fontFamily={'inherit'}>© {new Date().getFullYear()} Game Store. All Rights Reserved.</Text>
    </Box>
  );
}
export default Footer;