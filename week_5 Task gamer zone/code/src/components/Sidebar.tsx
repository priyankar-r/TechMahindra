import { Drawer, DrawerBody, DrawerHeader, DrawerOverlay, DrawerContent, DrawerCloseButton, VStack } from "@chakra-ui/react";
interface SidebarProps {
  isOpen: boolean;
  onClose: () => void;
}
function Sidebar({ isOpen, onClose }: SidebarProps) {
  return (
    <Drawer isOpen={isOpen} placement="right" onClose={onClose}>
      <DrawerOverlay />
      <DrawerContent bg="#1a1a1a" color="white">
        <DrawerCloseButton />
        <DrawerHeader fontFamily={'inherit'}>Game Categories</DrawerHeader>
        <DrawerBody>
          <VStack align="start">
            {["Action", "Racing", "Horror", "Strategy"].map((category) => (
              <button
                key={category}
                style={{
                  fontFamily: 'inherit',
                  background: "none",
                  color: "white",
                  border: "none",
                  padding: "8px",
                  cursor: "pointer",
                  width: "100%",
                  textAlign: "left",
                  transition: "0.2s",
                }}
                onMouseOver={(e) => ((e.target as HTMLButtonElement).style.background = "gray.700")}
                onMouseOut={(e) => ((e.target as HTMLButtonElement).style.background = "none")}
              >
                {category}
              </button>
            ))}
          </VStack>
        </DrawerBody>
      </DrawerContent>
    </Drawer>
  );
}
export default Sidebar;